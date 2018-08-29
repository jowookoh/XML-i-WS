package sesta.projekat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
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

	@Column
	private int vrednost;

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

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
}
