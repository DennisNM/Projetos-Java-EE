package br.com.senai.Dennis.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped

public class IndexBean implements Serializable{

// projeto apra retorna mensagem
	public String getMensagem() {
	
		return "Texto vindo do Bean";
	}
}
