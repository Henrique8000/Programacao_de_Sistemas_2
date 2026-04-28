package com.example.restdb;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString 
public class Titulo {
	
	@Id
	private long id;
	private String nome;
	private String esporte;
	private Double premio;
	
	public Titulo() {
	}
	
	public Titulo(long id, String nome, String esporte, Double premio) {
		this.id = id;
		this.nome = nome;
		this.esporte = esporte;
		this.premio = premio;
	}
	
}
