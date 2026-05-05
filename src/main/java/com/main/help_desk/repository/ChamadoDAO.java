/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.repository;

import com.main.help_desk.model.ChamadoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

@Repository
public class ChamadoDAO {
    public String addChamado(ChamadoDTO chamado){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("Insert into chamados (titulo, descricao, prioridade, funcionario_id) values (?, ?, ?, ?)");
            
            stmt.setString(1, chamado.getTitulo());
            stmt.setString(2, chamado.getDescricao());
            stmt.setString(3, chamado.getPrioridade());
            stmt.setInt(4, chamado.getFuncionarioId());
            
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao tentar cadastrar chamado.";
        }
        
        return "Chamado cadastrado com sucesso.";
    }
}
