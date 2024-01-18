package com.beckman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beckman.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}
