package com.grimaldi.To_DoList.services;

import com.grimaldi.To_DoList.dto.TarefaDto;
import com.grimaldi.To_DoList.entities.Tarefa;
import com.grimaldi.To_DoList.repositories.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa addTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    @Transactional(readOnly = true)
    public List<TarefaDto> findAll() {
        List<Tarefa> result = tarefaRepository.findAll();
        return result.stream()
                .map(TarefaDto::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<TarefaDto> findByStatus(boolean status) {
        List<Tarefa> result = tarefaRepository.findByStatus(status);
        return result.stream().map(TarefaDto::new).toList();
    }

    @Transactional(readOnly = true)
    public TarefaDto findById(Long id) {
        Tarefa result = tarefaRepository.findById(id).get();
        return new TarefaDto(result);
    }

    @Transactional
    public TarefaDto update(Long id, Tarefa newTarefa) {
        Tarefa oldTarefa = tarefaRepository.findById(id).get();
        oldTarefa.setDescricao(newTarefa.getDescricao());
        oldTarefa.setStatus(newTarefa.getStatus());
        oldTarefa.setTitulo(newTarefa.getTitulo());
        tarefaRepository.save(oldTarefa);

        return new TarefaDto(oldTarefa);
    }

    public void delete(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com id: " + id));
        tarefaRepository.delete(tarefa);
    }
}

