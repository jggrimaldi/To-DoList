package com.grimaldi.To_DoList.repositories;

import com.grimaldi.To_DoList.entities.Tarefa;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    public List<Tarefa> findByStatus(boolean status);
}
