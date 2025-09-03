package com.grimaldi.To_DoList.dto;

import com.grimaldi.To_DoList.entities.Tarefa;

//DTO que o usuario manda, n tem tudo
public class TarefaRequest {
    private String titulo;
    private String descricao;
    private Boolean status;

    public TarefaRequest(Tarefa tarefa) {
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
