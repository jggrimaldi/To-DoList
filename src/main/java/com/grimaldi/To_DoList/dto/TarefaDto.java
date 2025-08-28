package com.grimaldi.To_DoList.dto;

import com.grimaldi.To_DoList.entities.Tarefa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class TarefaDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean status;

    public TarefaDto() {
    }

    public TarefaDto(Tarefa tarefa) {
        descricao = tarefa.getDescricao();
        id = tarefa.getId();
        status = tarefa.getStatus();
        titulo = tarefa.getTitulo();
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
