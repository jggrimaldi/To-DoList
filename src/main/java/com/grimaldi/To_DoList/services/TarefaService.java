package com.grimaldi.To_DoList.services;

import com.grimaldi.To_DoList.dto.TarefaDto;
import com.grimaldi.To_DoList.entities.Tarefa;
import com.grimaldi.To_DoList.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa addTarefa(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<TarefaDto> findAll() {
        List<Tarefa> result = tarefaRepository.findAll();
        return result.stream()
                .map(TarefaDto::new)
                .toList();
    }

    public List<TarefaDto> findByStatus(boolean status) {
        List<Tarefa> result = tarefaRepository.findByStatus(status);
        return result.stream().map(TarefaDto::new).toList();
    }

    public TarefaDto findById(Long id) {
        Tarefa result = tarefaRepository.findById(id).get();
        return new TarefaDto(result);
    }
}
