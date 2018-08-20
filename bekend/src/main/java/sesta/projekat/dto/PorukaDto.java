package sesta.projekat.dto;

public class PorukaDto {
    private Long posiljalacId;

    private Long rezervacijaId;

    private String tekst;

    public PorukaDto() {
    }

    public PorukaDto(Long posiljalacId, Long rezervacijaId, String tekst) {
        this.posiljalacId = posiljalacId;
        this.rezervacijaId = rezervacijaId;
        this.tekst = tekst;
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
