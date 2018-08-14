package com.example.agent.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Slika {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Smestaj smestaj;
	
	@Column
	private Blob slika;
}
