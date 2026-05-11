/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.controller;

import com.main.help_desk.model.ChamadoDTO;
import com.main.help_desk.model.ChamadoFuncionarioDTO;
import com.main.help_desk.service.ChamadoService;
import com.main.help_desk.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chamados")
public class ChamadoController {
    @Autowired
    private ChamadoService service;
    
    @Autowired
    private TokenService tokenService;
    
    @PostMapping
    public String addChamado(@RequestBody ChamadoDTO chamado){
        return service.addChamado(chamado);
    }
    
    @GetMapping("/abertos")
    public List<ChamadoFuncionarioDTO> getChamadosAbertos(@RequestHeader("Authorization") String auth){
        String token = auth.replace("Bearer ", "");
        if (tokenService.validToken(token)){
           return service.getChamadosAbertos();
        } else {
            return null;
        }
    }
    
    @PutMapping("/{id}/concluir")
    public String resolverChamado(@PathVariable int id, @RequestBody ChamadoDTO dto){
        return service.resolverChamado(id, dto.getSolucaoAplicada());
    }
}
