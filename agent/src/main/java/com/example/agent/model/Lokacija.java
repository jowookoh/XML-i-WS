package com.example.agent.model;

import javax.persistence.*;

@Entity
public class Lokacija {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long bekendId;
	
	public Long getBekendId() {
		return bekendId;
	}
	
	public void setBekendId(Long bekendId) {
		this.bekendId = bekendId;
	}
	
	@Column
	private String drzava;
	
	@Column
	private String mesto;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDrzava() {
		return drzava;
	}
	
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	
	public String getMesto() {
		return mesto;
	}
	
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
}
