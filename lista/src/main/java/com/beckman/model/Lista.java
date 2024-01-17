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
@Column(name ="Tarefa")
private List<Tarefa> tarefas;
@JoinColumn(name= "user_id")
private User user;
public Lista() {
	
}

public Lista(Long id, String nome, List<Tarefa> tarefas,User user) {
	this.id = id;
	this.nome = nome;
	this.tarefas = tarefas; 
	this.user = user;
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

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}




}
