/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.repository;

import com.main.help_desk.model.ChamadoDTO;
import com.main.help_desk.model.ChamadoFuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<ChamadoFuncionarioDTO> getChamadosAbertos(){
        List<ChamadoFuncionarioDTO> dados = new ArrayList();
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("select * from chamados inner join funcionarios on chamados.funcionario_id = funcionarios.id where chamados.status = 'Pendente'");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ChamadoFuncionarioDTO chamadoAberto = new ChamadoFuncionarioDTO();
                chamadoAberto.setTitulo(rs.getString("titulo"));
                chamadoAberto.setDescricao(rs.getString("descricao"));
                chamadoAberto.setStatus(rs.getString("status"));
                chamadoAberto.setPrioridade(rs.getString("prioridade"));
                chamadoAberto.setDataAbertura(rs.getTimestamp("data_abertura"));
                chamadoAberto.setNomeFuncionario(rs.getString("nome"));
                chamadoAberto.setEmailFuncionario(rs.getString("email"));
                chamadoAberto.setSolucaoAplicada(rs.getString("solucao_aplicada"));
                dados.add(chamadoAberto);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return dados;
    }
    
    public boolean estaResolvido(int id){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String status = null;
            
            stmt = conn.prepareStatement("Select status from chamados where id = ?");
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if (rs.next()){
                status = rs.getString("status");
                if (!"Resolvido".equals(status)) return false;
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public String resolverChamado(int id, String solucaoAplicada){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String status = null;
            
            stmt = conn.prepareStatement("update chamados set status = 'Resolvido', solucao_aplicada = ? where id = ?");
            
            stmt.setString(1, solucaoAplicada);
            stmt.setInt(2, id);
            
           stmt.executeUpdate();
            
            
        }catch(SQLException e){
            e.printStackTrace();
            return "Erro ao mudar status do chamado.";
        }
        
        return "Chamado resolvido com sucesso!";
    }
}
