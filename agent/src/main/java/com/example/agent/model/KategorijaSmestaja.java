package com.example.agent.model;

import javax.persistence.*;

@Entity
public class KategorijaSmestaja {
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
	private String naziv;
	
	public String getNaziv() {
		return naziv;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
