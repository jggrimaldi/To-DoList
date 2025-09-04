package com.grimaldi.To_DoList.controller;

import com.grimaldi.To_DoList.dto.TarefaRequest;
import com.grimaldi.To_DoList.dto.TarefaResponse;
import com.grimaldi.To_DoList.dto.TarefaUpdateRequest;
import com.grimaldi.To_DoList.entities.Tarefa;
import com.grimaldi.To_DoList.services.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@Validated
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping(value = "/new")
    public ResponseEntity<TarefaResponse> add(@Valid @RequestBody TarefaRequest dto){
        Tarefa  tarefa = new Tarefa();
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setTitulo(dto.getTitulo());

        Tarefa savedTarefa = tarefaService.addTarefa(tarefa);

        TarefaResponse response = new TarefaResponse();
        response.setId(savedTarefa.getId());
        response.setDescricao(savedTarefa.getDescricao());
        response.setStatus(savedTarefa.getStatus());
        response.setTitulo(response.getTitulo());

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<TarefaResponse> findAll(){
        return tarefaService.findAll();
    }

    @GetMapping(value = "/status/{status}")
    public List<TarefaResponse> findBystatus(@PathVariable boolean status) {
        return tarefaService.findByStatus(status);
    }

    @GetMapping(value = "/{id}")
    public TarefaResponse finById(Long id) {
        return tarefaService.findById(id);
    }

    @PutMapping(value = "/novo/{id}")
    public TarefaResponse update(@PathVariable Long id, @Valid @RequestBody TarefaRequest newTarefa) {
        return tarefaService.update(id, newTarefa);
    }

    @PatchMapping(value = "/{id}")
    public TarefaResponse partialUpdate(@PathVariable Long id, @Valid  @RequestBody TarefaUpdateRequest newTarefa) {
        return tarefaService.partialUpdate(id, newTarefa);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Long id) {
        tarefaService.delete(id);
    }
}

