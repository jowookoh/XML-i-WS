package sesta.projekat.dto;

public class PorukaDto {
    private Long id;

    private Long posiljalacId;

    private Long rezervacijaId;

    private String tekst;

    public PorukaDto() {
    }

    public PorukaDto(Long id, Long posiljalacId, Long rezervacijaId, String tekst) {
        this.id = id;
        this.posiljalacId = posiljalacId;
        this.rezervacijaId = rezervacijaId;
        this.tekst = tekst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPosiljalacId() {
        return posiljalacId;
    }

    public void setPosiljalacId(Long posiljalacId) {
        this.posiljalacId = posiljalacId;
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
