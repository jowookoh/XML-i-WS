package sesta.projekat.model;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table
public class Slika {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Smestaj smestaj;
	
	@Column
	private String slika;
}
