package br.com.rafaelcosta.application.bean;


import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
// formatar padrãoes
@Named
@ApplicationScoped
public class FormatterBean implements Serializable {
//entregar localização e lingua
	private static final Locale LOCALE_BR = new Locale("pt", "BR");
	// formatar valor
	public String formatarMoeda(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR);
		return nf.format(valor);
	}
}
