package com.beckman.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Lista {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name ="ID")
private Long id;
@Column(name ="Nome")
private String nome;
@OneToMany(mappedBy="lista", cascade= CascadeType.ALL)
private List<Tarefa> tarefas;
@JoinColumn(name= "users_id")
private Users users;
public Lista() {
	
}

public Lista(Long id, String nome, List<Tarefa> tarefas,Users users) {
	this.id = id;
	this.nome = nome;
	this.tarefas = tarefas; 
	this.users = users;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public List<Tarefa> getTarefas() {
	return tarefas;
}
public void setTarefas(List<Tarefa> tarefas) {
	this.tarefas = tarefas;
}

public Users getUsers() {
	return users;
}

public void setUser(Users users) {
	this.users = users;
}




}
