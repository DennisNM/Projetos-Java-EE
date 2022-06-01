package br.com.senai.willianFerreira.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.crypto.digest.SHAReverseInterleave;

@Named
@RequestScoped
@SuppressWarnings("serial")

public class PageBean implements Serializable  {
	
 private String texto;
 private String textoInvertido;
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getTextoInvertido() {
	return textoInvertido;
}
public void setTextoInvertido(String textoInvertido) {
	this.textoInvertido = textoInvertido;
}
 
 
public String inversao() {
	
	textoInvertido= new StringBuilder(texto).reverse().toString();
	return textoInvertido;
	
}



	

}