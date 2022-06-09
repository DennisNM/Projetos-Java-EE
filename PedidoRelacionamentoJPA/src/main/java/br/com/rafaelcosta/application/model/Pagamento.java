package br.com.rafaelcosta.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pagamento implements Serializable {
	// enum para padronizar
	public enum TipoPagamento {
		CARTAO_CREDITO,
		BOLETO
	}

	@Id
	@GeneratedValue
	private Integer id;
	// tipo de enum para que o que va para o banco a strnig
	@Enumerated(EnumType.STRING)
	//criando o nome da coluna no banco.
	@Column(name = "tipo_pagto", length = 20, nullable = false)
	private TipoPagamento tipoPagto;
	
// pagamento que tem a chamada do pedido ("forgein key")
	@OneToOne(mappedBy = "pagamento")
	private Pedido pedido;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
}
