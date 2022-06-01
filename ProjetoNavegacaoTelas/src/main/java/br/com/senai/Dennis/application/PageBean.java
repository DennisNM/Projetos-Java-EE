package br.com.senai.Dennis.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PageBean implements Serializable {
// string com o nome da pagina
	private String page;
	//enum das page
	public enum pages{
		page_a,page_b
	}
	// Pegar a pagina
	public String getPage() {
		return page;
	}
// setar a apgina
	public void setPage(String page) {
		this.page = page;
	} 	

	// ver que pagian é com if else composto para redirecionar a pagina
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
