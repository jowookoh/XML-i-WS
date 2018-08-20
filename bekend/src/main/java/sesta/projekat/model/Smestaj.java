package sesta.projekat.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Smestaj {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private TipSmestaja tipSmestaja;
	
	@ManyToOne
	@JoinColumn
	private KategorijaSmestaja kategorijaSmestaja;
	
	/*@ManyToOne
	@JoinColumn
	private Agent agent;*/
	
	@ManyToOne
	@JoinColumn
	private Lokacija lokacija;
	
	@Column
	private String opis;
	
	@Column
	private int brojOsoba;
	@OneToMany(mappedBy = "smestaj")
	private List<Cena> cene = new ArrayList();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public TipSmestaja getTipSmestaja() {
		return tipSmestaja;
	}
	
	public void setTipSmestaja(TipSmestaja tipSmestaja) {
		this.tipSmestaja = tipSmestaja;
	}
	
	public KategorijaSmestaja getKategorijaSmestaja() {
		return kategorijaSmestaja;
	}
	
	public void setKategorijaSmestaja(KategorijaSmestaja kategorijaSmestaja) {
		this.kategorijaSmestaja = kategorijaSmestaja;
	}
	
	public Lokacija getLokacija() {
		return lokacija;
	}
	
	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public int getBrojOsoba() {
		return brojOsoba;
	}
	
	public void setBrojOsoba(int brojOsoba) {
		this.brojOsoba = brojOsoba;
	}

	public List<Cena> getCene() {
		return cene;
	}

	public void setCene(List<Cena> cene) {
		this.cene = cene;
	}

}
