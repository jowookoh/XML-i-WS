package com.example.agent.model;

import javax.persistence.*;

@Entity
@Table
public class Poruka {
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
    private Korisnik posiljalac;

    @ManyToOne
    @JoinColumn
    private Rezervacija rezervacija;

    @Column
    private String tekst;

    @Column
    private int poRedu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
	
	public Korisnik getPosiljalac() {
		return posiljalac;
	}
	
	public void setPosiljalac(Korisnik posiljalac) {
		this.posiljalac = posiljalac;
	}
	
	public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getPoRedu() {
        return poRedu;
    }

    public void setPoRedu(int poRedu) {
        this.poRedu = poRedu;
    }
}
