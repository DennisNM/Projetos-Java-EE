package br.com.senai.Dennis.application.config;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
@SuppressWarnings("serial")

public class PageBean implements Serializable {
	private String nome;

	@Inject
	private Flash flash;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String processar() {
		flash.put("nomeDoUsuario", nome);

		return "result?faces-redirect=true";
	}

}
