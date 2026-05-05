/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.controller;

import com.main.help_desk.model.ChamadoDTO;
import com.main.help_desk.model.ChamadoFuncionarioDTO;
import com.main.help_desk.service.ChamadoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/chamados")
public class ChamadoController {
    @Autowired
    private ChamadoService service;
    
    @PostMapping
    public String addChamado(@RequestBody ChamadoDTO chamado){
        return service.addChamado(chamado);
    }
    
    @GetMapping("/abertos")
    public List<ChamadoFuncionarioDTO> getChamadosAbertos(){
        return service.getChamadosAbertos();
    }
    
    @PutMapping("/{id}/concluir")
    public String resolverChamado(@PathVariable int id, @RequestBody ChamadoDTO dto){
        return service.resolverChamado(id, dto.getSolucaoAplicada());
    }
}
