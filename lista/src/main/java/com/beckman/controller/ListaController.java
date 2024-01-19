package com.beckman.controller;

import com.beckman.model.Lista;
import com.beckman.services.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("listas")
public class ListaController {

    private final ListaService listaService;

    @Autowired
    public ListaController(ListaService listaService) {
        this.listaService = listaService;
    }

    @GetMapping
    public List<Lista> getAllLists() {
        return listaService.getAllLists();
    }

    @GetMapping("/user/{userId}")
    public List<Lista> getAllListsByUserId(@PathVariable Long userId) {
        return listaService.getAllListsByUserId(userId);
    }

    @GetMapping("/user/{userId}/quantidade")
    public Long quantidadeDeListasByUserId(@PathVariable Long userId) {
        return listaService.quantidadeDeListasByUserId(userId);
    }

    @PostMapping
    public Lista saveLista(@RequestBody Lista lista) {
        return listaService.saveLista(lista);
    }

    @PutMapping("/{id}")
    public Lista updateLista(@PathVariable Long id, @RequestBody Lista updatedList) {
        return listaService.updateLista(id, updatedList);
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable Long id) {
        listaService.deleteList(id);
    }
}
