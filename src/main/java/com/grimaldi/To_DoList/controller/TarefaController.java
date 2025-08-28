package com.grimaldi.To_DoList.controller;

import com.grimaldi.To_DoList.dto.TarefaDto;
import com.grimaldi.To_DoList.entities.Tarefa;
import com.grimaldi.To_DoList.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping(value = "/new")
    public ResponseEntity<Tarefa> add(@RequestBody TarefaDto dto){
        Tarefa tarefa = new Tarefa();
        tarefa.setId(dto.getId());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setTitulo(dto.getTitulo());

        Tarefa newtarefa = tarefaService.addTarefa(tarefa);
        return ResponseEntity.ok(newtarefa);
    }

    @GetMapping
    public List<TarefaDto> findAll(){
        return tarefaService.findAll();
    }

    @GetMapping(value = "/status/{status}")
    public List<TarefaDto> findBystatus(@PathVariable boolean status) {
        return tarefaService.findByStatus(status);
    }

    @GetMapping(value = "/{id}")
    public TarefaDto finById(Long id) {
        return tarefaService.findById(id);
    }
}
