package com.grimaldi.To_DoList.dto;

import com.grimaldi.To_DoList.entities.Tarefa;

//DTO da API para retornar ao cliente
public class TarefaResponse {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean status;

    public TarefaResponse(Tarefa tarefa) {
        id = tarefa.getId();
        titulo = tarefa.getTitulo();
        descricao = tarefa.getDescricao();
        status = tarefa.getStatus();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
