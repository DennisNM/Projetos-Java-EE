package br.com.senai.willianFerreira.application.model;

import javax.inject.Named;

@Named("Estado")

public class Estado {

	String nome;
	String sigla;

	public Estado(String sigla, String nome) {
		super();
		this.nome = nome;
		this.sigla = sigla;

		// TODO Auto-generated constructor stub
	}

	public Estado() {
		// TODO Auto-generated constructor stub
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}


	

}
