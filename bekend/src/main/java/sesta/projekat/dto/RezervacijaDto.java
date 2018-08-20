package sesta.projekat.dto;

import java.util.Date;

public class RezervacijaDto {
    private Long smestajId;
    private Date pocetak;
    private Date kraj;
    private String komentar;
    private int ocena;
    private boolean odobrenKomentar;
    private boolean realizovana;
    private Long id;

    public RezervacijaDto() {
    }

    public RezervacijaDto(Long id, Long smestajId, Date pocetak, Date kraj, String komentar, int ocena, boolean odobrenKomentar, boolean realizovana) {

        this.id = id;
        this.smestajId = smestajId;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.komentar = komentar;
        this.ocena = ocena;
        this.odobrenKomentar = odobrenKomentar;
        this.realizovana = realizovana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSmestajId() {
        return smestajId;
    }

    public void setSmestajId(Long smestajId) {
        this.smestajId = smestajId;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
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
}
