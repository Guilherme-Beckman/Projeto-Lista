package com.beckman.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beckman.model.Lista;
import com.beckman.model.Tarefa;
import com.beckman.repositories.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {

private TarefaRepository tarefaRepository;
@Autowired
public TarefaService(TarefaRepository tarefaRepository) {
	this.tarefaRepository = tarefaRepository;
}

public List<Tarefa> getAllTarefas(){
	return tarefaRepository.findAll();
}
public List<Tarefa> getAllTarefasByListId(Long listId){
	boolean temLista= false;
	List<Tarefa> tarefasDaLista= new ArrayList<>();

	List<Tarefa> tarefas = tarefaRepository.findAll();
	for (int i=0; i<tarefas.size(); i++) {
		if (tarefas.get(i).getLista().getId().equals(listId)) {
			tarefasDaLista.add(tarefas.get(i));
			temLista= true;
		}
		
	}
	if (temLista==true) {
		return tarefasDaLista;
	}else {
		return null;
	}
}
public Long quantidadeDeTarefasByListaId(Long listaId) {
	boolean temTarefa= false;
	Long quantidade= 0L;

	List<Tarefa> tarefas = tarefaRepository.findAll();
	for (int i=0; i<tarefas.size(); i++) {
		if (tarefas.get(i).getLista().getId().equals(listaId)) {
			quantidade++;
			temTarefa= true;
		}
		
	}
	if (temTarefa==true) {
		return quantidade;
	}else {
		return null;
	}
}
public Tarefa saveLista(Tarefa tarefa) {
    return tarefaRepository.save(tarefa);
}
public Tarefa updateTarefa(Long id, Tarefa updatedTarefa) {
	Tarefa existingTarefa= tarefaRepository.findById(id).orElse(null);
	if (existingTarefa==null) {
		throw new EntityNotFoundException("Essa tarefa não existe");
	}
	existingTarefa.setNome(updatedTarefa.getNome());
	existingTarefa.setDescricao(updatedTarefa.getDescricao());
	existingTarefa.setPrazo(updatedTarefa.getPrazo());
	existingTarefa.setFinalizado(updatedTarefa.isFinalizado());
	existingTarefa.setLista(updatedTarefa.getLista());
	return tarefaRepository.save(existingTarefa);
}
public void deleteTarefa(Long id) {
	Tarefa existingTarefa = tarefaRepository.findById(id).orElse(null);
	if (existingTarefa==null) {
		throw new EntityNotFoundException("Essa tarefa não existe");		
	}
	tarefaRepository.deleteById(id);
}

}
