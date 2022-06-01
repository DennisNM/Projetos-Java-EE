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
// inject para "chamar" o flash
	@Inject
	private Flash flash;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
// flash  na view ("o que aparece")
	public String processar() {
		flash.put("nomeDoUsuario", nome);

		return "result?faces-redirect=true";
	}

}
