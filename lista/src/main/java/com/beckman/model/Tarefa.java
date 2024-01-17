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



}
