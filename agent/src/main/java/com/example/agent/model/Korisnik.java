package com.example.agent.model;

import javax.persistence.*;

@Entity
@Table
public class Korisnik {
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
	private String kime;
	
	@Column
	private String lozinka;
	
	@Column
	private String tipKorisnika;
	
	public String getTipKorisnika() {
		return tipKorisnika;
	}
	
	public void setTipKorisnika(String tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getKime() {
		return kime;
	}
	
	public void setKime(String kime) {
		this.kime = kime;
	}
	
	public String getLozinka() {
		return lozinka;
	}
	
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
}
