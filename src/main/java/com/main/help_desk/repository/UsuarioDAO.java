/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.repository;

import com.main.help_desk.model.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {
    public String criarUsuario(UsuarioDTO usuario){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("Insert into usuarios (nome, email, senha) values (?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeQuery();
            
        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao tentar criar usuario";
        }
    
        return "Usuario Adicionado com sucesso.";
    }
}
