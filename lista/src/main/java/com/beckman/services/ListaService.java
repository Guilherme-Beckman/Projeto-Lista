package com.beckman.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beckman.model.Lista;
import com.beckman.repositories.ListaRepository;

@Service
public class ListaService {
private ListaRepository listaRepository;

@Autowired
public ListaService(ListaRepository listaRepository) {
	this.listaRepository = listaRepository;
}
public List<Lista> getAllLists(){
	return listaRepository.findAll();
}
public List<Lista> getAllListsByUserId(Long userId){
	boolean temLista= false;
	List<Lista> listasDoUsuario= new ArrayList<>();

	List<Lista> listas = listaRepository.findAll();
	for (int i=0; i<listas.size(); i++) {
		if (listas.get(i).getUsers().getId().equals(userId)) {
			listasDoUsuario.add(listas.get(i));
			temLista= true;
		}
		
	}
	if (temLista==true) {
		return listasDoUsuario;
	}else {
		return null;
	}
}
public Long quantidadeDeListasByUserId(Long userId) {
	boolean temLista= false;
	Long quantidade= 0L;

	List<Lista> listas = listaRepository.findAll();
	for (int i=0; i<listas.size(); i++) {
		if (listas.get(i).getUsers().getId().equals(userId)) {
			quantidade++;
			temLista= true;
		}
		
	}
	if (temLista==true) {
		return quantidade;
	}else {
		return null;
	}
}
public Lista saveLista(Lista lista) {
    return listaRepository.save(lista);
}
}
