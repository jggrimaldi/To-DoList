package com.grimaldi.To_DoList.entities;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String titulo;
    private String descricao;
    private Boolean status;

    public Tarefa(){
    }

    public Tarefa(String descricao, Long id, Boolean status, String titulo) {
        this.descricao = descricao;
        Id = id;
        this.status = status;
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(Id, tarefa.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}