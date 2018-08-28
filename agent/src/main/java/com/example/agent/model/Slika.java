package com.example.agent.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Slika {
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
	
	@Column
	private String slika;

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

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
