/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.controller;

import com.main.help_desk.model.UsuarioDTO;
import com.main.help_desk.service.TokenService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    private TokenService service;
    
    @GetMapping("/token")
    public String getToken(@RequestBody UsuarioDTO usuario){
        return service.getToken(usuario);
    }
    
    @PostMapping("/validar-token")
    public String validarToken(@RequestParam String token) {
        if (service.validToken(token)) {
            Claims claims = service.extrairClaims(token);
            return "Token válido! Subject: " + claims.getSubject() + 
                   ", Emitido em: " + claims.getIssuedAt() + 
                   ", Expira em: " + claims.getExpiration();
        } else {
            return "Token inválido ou expirado!";
        }
    }
}
