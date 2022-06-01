package br.com.senai.willianFerreira.application.model;

import javax.inject.Named;

@Named("Telefone")

public class Telefone {
	String ddd;
	String numero;
	Tipo tipo;
	
	
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
}
