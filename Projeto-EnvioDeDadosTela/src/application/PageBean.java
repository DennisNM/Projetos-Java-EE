package br.com.senai.Dennis.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class PageBean implements Serializable {

	private String page;
	
	public enum pages{
		page_a,page_b
	}
	
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	} 	

	
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
