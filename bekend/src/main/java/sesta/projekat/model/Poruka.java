package sesta.projekat.model;

import javax.persistence.*;

@Entity
@Table
public class Poruka {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long idPosiljalac;

    @ManyToOne
    @JoinColumn
    private Rezervacija rezervacija;

    @Column
    private String tekst;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPosiljalac() {
        return idPosiljalac;
    }

    public void setIdPosiljalac(Long idPosiljalac) {
        this.idPosiljalac = idPosiljalac;
    }

    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    public void setRezervacijaId(Rezervacija rezervacija) {
        this.rezervacija = rezervacija;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
