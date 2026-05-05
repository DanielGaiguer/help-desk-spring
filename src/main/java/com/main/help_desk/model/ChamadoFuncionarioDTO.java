/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main.help_desk.model;

import java.sql.Timestamp;


/**
 *
 * @author gaigu
 */
public class ChamadoFuncionarioDTO {
    private String titulo;
    private String descricao;
    private String solucaoAplicada;
    private String status;
    private String prioridade;
    private Timestamp dataAbertura;
    private String nomeFuncionario;
    private String emailFuncionario;

    public ChamadoFuncionarioDTO() {
    }

    public ChamadoFuncionarioDTO(String titulo, String descricao, String solucaoAplicada, String status, String prioridade, Timestamp dataAbertura, String nomeFuncionario, String emailFuncionario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.solucaoAplicada = solucaoAplicada;
        this.status = status;
        this.prioridade = prioridade;
        this.dataAbertura = dataAbertura;
        this.nomeFuncionario = nomeFuncionario;
        this.emailFuncionario = emailFuncionario;
    }
 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public Timestamp getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Timestamp dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getSolucaoAplicada() {
        return solucaoAplicada;
    }

    public void setSolucaoAplicada(String solucaoAplicada) {
        this.solucaoAplicada = solucaoAplicada;
    }
    
    
}
