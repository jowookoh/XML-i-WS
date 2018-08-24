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

    @Column
    private Long rezervacijaId;

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

    public Long getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Long rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
