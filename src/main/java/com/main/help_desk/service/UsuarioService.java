/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.service;

import com.main.help_desk.model.UsuarioDTO;
import com.main.help_desk.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioDAO repository;
    
    public String criarUsuario(UsuarioDTO usuario){
        return repository.criarUsuario(usuario);
    }
    
    public UsuarioDTO logarUsuario(UsuarioDTO usuario){
        return repository.login(usuario);
    }
}
