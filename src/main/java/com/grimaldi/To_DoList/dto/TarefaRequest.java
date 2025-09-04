package com.grimaldi.To_DoList.dto;

import com.grimaldi.To_DoList.entities.Tarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//DTO que o usuario manda, n tem tudo
public class TarefaRequest {

    @NotBlank(message = "O título não pode ficar vazio")
    @Size(max = 100, message = "O título não pode ter mais que 100 caracteres")
    private String titulo;

    @Size(max = 500, message = "A descrição não pode ter mais que 500 caracteres")
    private String descricao;
    private Boolean status;

    public TarefaRequest() {
    }

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
