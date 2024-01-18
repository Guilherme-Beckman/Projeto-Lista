package com.beckman.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column (name="ID")
private Long id;
@Column (name="Nome")
private String nome;
@Column (name= "Descrição")
private String descricao;
@Column (name= "Prazo")
private LocalDateTime prazo;
@Column (name= "Finalizado")
private boolean finalizado;

@ManyToOne
@JoinColumn(name= "lista_id")
private Lista lista;

public Tarefa() {
	
}

public Tarefa(Long id, String nome, String descricao, LocalDateTime prazo, boolean finalizado, Lista lista) {
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.prazo = prazo;
	this.finalizado = finalizado;
	this.lista = lista;
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

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public LocalDateTime getPrazo() {
	return prazo;
}

public void setPrazo(LocalDateTime prazo) {
	this.prazo = prazo;
}

public boolean isFinalizado() {
	return finalizado;
}

public void setFinalizado(boolean finalizado) {
	this.finalizado = finalizado;
}

public Lista getLista() {
	return lista;
}

public void setLista(Lista lista) {
	this.lista = lista;
}



}
