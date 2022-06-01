package br.com.senai.Dennis.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PageBean implements Serializable {
// string com nome da pagina
	private String page;
	// enem da pagina
	public enum pages{
		page_a,page_b
	}
	/get e set da pagina
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	} 	

	// retornar a pagina  com if else composto
	public pages goTo() {
		if ("a".equals(page)) {
			
			return  pages.page_a;
			
		} else if("b".equals(page)) {
			return pages.page_b;
			
		} else {
			return null;
		}
	}
}
