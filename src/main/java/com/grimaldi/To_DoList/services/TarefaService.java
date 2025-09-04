package com.grimaldi.To_DoList.services;

import com.grimaldi.To_DoList.dto.TarefaRequest;
import com.grimaldi.To_DoList.dto.TarefaResponse;
import com.grimaldi.To_DoList.dto.TarefaUpdateRequest;
import com.grimaldi.To_DoList.entities.Tarefa;
import com.grimaldi.To_DoList.repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa addTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    @Transactional(readOnly = true)
    public List<TarefaResponse> findAll() {
        List<Tarefa> result = tarefaRepository.findAll();
        return result.stream()
                .map(TarefaResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TarefaResponse> findByStatus(boolean status) {
        List<Tarefa> result = tarefaRepository.findByStatus(status);
        return result.stream().map(TarefaResponse::new).toList();
    }

    @Transactional(readOnly = true)
    public TarefaResponse findById(Long id) {
        Tarefa result = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));;
        return new TarefaResponse(result);
    }

    @Transactional
    public TarefaResponse update(Long id, TarefaRequest newTarefa) {
        Tarefa oldTarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));;
        oldTarefa.setDescricao(newTarefa.getDescricao());
        oldTarefa.setStatus(newTarefa.getStatus());
        oldTarefa.setTitulo(newTarefa.getTitulo());
        tarefaRepository.save(oldTarefa);

        return new TarefaResponse(oldTarefa);
    }

    @Transactional
    public TarefaResponse partialUpdate(Long id, TarefaUpdateRequest partialTarefa) {
        Tarefa oldTarefa = tarefaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));
        if(partialTarefa.getStatus() != null) {
            oldTarefa.setStatus(partialTarefa.getStatus());
        } else if (partialTarefa.getDescricao() != null) {
            oldTarefa.setDescricao(partialTarefa.getDescricao());
        } else if (partialTarefa.getTitulo() != null) {
            oldTarefa.setTitulo(partialTarefa.getTitulo());
        }
        tarefaRepository.save(oldTarefa);

        return new TarefaResponse(oldTarefa);
    }

    public void delete(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));
        tarefaRepository.delete(tarefa);
    }
}

