package br.com.senai.willianFerreira.application.model;

import javax.inject.Named;

@Named("Interreses")

public class Interesses {
	public Interesses(int id, String area) {
		// TODO Auto-generated constructor stub
	}
	
	Integer id;
	String area;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	
	
	
}

