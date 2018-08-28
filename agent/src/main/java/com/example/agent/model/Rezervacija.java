package com.example.agent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rezervacija {
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
	
	@ManyToOne
	@JoinColumn
	private Smestaj smestaj;
	
	/*@ManyToOne
	@JoinColumn
	private Klijent klijent;*/
	
	@Column
	private Date od;
	
	@Column
	private Date paOndaDo;
	
	@Column
	private int ocena;
	
	@Column
	private  String komentar;
	
	@Column
	private boolean odobrenKomentar;
	
	@Column
	private boolean realizovana;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Smestaj getSmestaj() {
		return smestaj;
	}
	
	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
	
	public int getOcena() {
		return ocena;
	}
	
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	public String getKomentar() {
		return komentar;
	}
	
	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}
	
	public boolean isOdobrenKomentar() {
		return odobrenKomentar;
	}
	
	public void setOdobrenKomentar(boolean odobrenKomentar) {
		this.odobrenKomentar = odobrenKomentar;
	}
	
	public boolean isRealizovana() {
		return realizovana;
	}
	
	public void setRealizovana(boolean realizovana) {
		this.realizovana = realizovana;
	}
	
	public Date getOd() {
		return od;
	}
	
	public void setOd(Date od) {
		this.od = od;
	}
	
	public Date getPaOndaDo() {
		return paOndaDo;
	}
	
	public void setPaOndaDo(Date paOndaDo) {
		this.paOndaDo = paOndaDo;
	}
}
