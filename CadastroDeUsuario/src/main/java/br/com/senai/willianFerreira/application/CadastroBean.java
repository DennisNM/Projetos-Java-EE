package br.com.senai.willianFerreira.application;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.senai.willianFerreira.application.listas.ListasObjeto;
import br.com.senai.willianFerreira.application.model.Endereco;
import br.com.senai.willianFerreira.application.model.Estado;
import br.com.senai.willianFerreira.application.model.Pessoa;
import br.com.senai.willianFerreira.application.model.Telefone;

@Named("cadastro")
@RequestScoped
@SuppressWarnings("serial")

public class CadastroBean implements Serializable  {

private Pessoa pessoa;

	public Pessoa getPessoa() {
		if(pessoa==null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
			
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		 this.pessoa= pessoa;
	 }
	
	public List<Estado> getEstados(){
		return ListasObjeto.ESTADOS;
	}
	
}

 