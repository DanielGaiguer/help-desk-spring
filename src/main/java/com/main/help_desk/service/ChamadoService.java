/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.service;

import com.main.help_desk.model.ChamadoDTO;
import com.main.help_desk.model.ChamadoFuncionarioDTO;
import com.main.help_desk.repository.ChamadoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoDAO repository;
    
    public String addChamado(ChamadoDTO chamado){
        String prioridade;

        if (chamado.getDescricao().toLowerCase().contains("urgente")) {
            prioridade = "Alta";
        } else if (chamado.getPrioridade() == null || chamado.getPrioridade().isBlank()) {
            prioridade = "Normal";
        } else {
            prioridade = chamado.getPrioridade();
        }
        
        chamado.setPrioridade(prioridade);

        return repository.addChamado(chamado);
    }
    
    public List<ChamadoFuncionarioDTO> getChamadosAbertos(){
        return repository.getChamadosAbertos();
    }
    
    public String resolverChamado(int id){
        if(repository.estaResolvido(id)){
            return "Este chamado já está resolvido.";
        }
        
        return repository.resolverChamado(id);
    }
}
