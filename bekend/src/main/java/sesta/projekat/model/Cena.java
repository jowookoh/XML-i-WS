package sesta.projekat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Cena {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Smestaj smestaj;
	
	@Column
	private Date mesec;
	
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
	
	public Date getMesec() {
		return mesec;
	}
	
	public void setMesec(Date mesec) {
		this.mesec = mesec;
	}
}
