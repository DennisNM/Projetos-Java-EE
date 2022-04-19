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
	
	private Integer numero1;
	private Integer numero2;
	private Integer numero3;
	private Integer result;
	
	
	

	public Integer getNumero1() {
		return numero1;
	}


	public void setNumero1(Integer numero1) {
		this.numero1 = numero1;
	}


	public Integer getNumero2() {
		return numero2;
	}


	public void setNumero2(Integer numero2) {
		this.numero2 = numero2;
	}


	public Integer getNumero3() {
		return numero3;
	}


	public void setNumero3(Integer numero3) {
		this.numero3 = numero3;
	}

	
	
	

	@Inject
	private Flash flash;
	
	public void somar() {
		result = numero1+ numero2 +numero3;
		
	}


	public String processar() {
		
		
		
		flash.put("nomeDoUsuario", result);

		return "result?faces-redirect=true";
	}

}
