package com.beckman.controller;

import com.beckman.model.Tarefa;
import com.beckman.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> getAllTarefas() {
        return tarefaService.getAllTarefas();
    }

    @GetMapping("/lista/{listId}")
    public List<Tarefa> getAllTarefasByListId(@PathVariable Long listId) {
        return tarefaService.getAllTarefasByListId(listId);
    }

    @GetMapping("/lista/{listId}/quantidade")
    public Long quantidadeDeTarefasByListaId(@PathVariable Long listId) {
        return tarefaService.quantidadeDeTarefasByListaId(listId);
    }

    @PostMapping
    public Tarefa saveTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.saveLista(tarefa);
    }

    @PutMapping("/{id}")
    public Tarefa updateTarefa(@PathVariable Long id, @RequestBody Tarefa updatedTarefa) {
        return tarefaService.updateTarefa(id, updatedTarefa);
    }

    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteTarefa(id);
    }
}
