/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.controller;

import com.main.help_desk.model.UsuarioDTO;
import com.main.help_desk.service.TokenService;
import com.main.help_desk.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    
    @Autowired
    private TokenService serviceToken;
    
    @PostMapping("/criar")
    public String criarUsuario(@RequestBody UsuarioDTO usuario){
        return service.criarUsuario(usuario);
    }
    
    @PostMapping("login")
    public String logarUsuario(@RequestBody UsuarioDTO usuario){
        service.logarUsuario(usuario);
        return serviceToken.getToken(usuario);
    }
   
}
