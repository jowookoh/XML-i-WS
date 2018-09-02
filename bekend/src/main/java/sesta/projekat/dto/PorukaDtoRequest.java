package sesta.projekat.dto;

public class PorukaDtoRequest {
    private String posiljalac;
    private Long idRezervacije;
    private String tekst;

    public PorukaDtoRequest() {
    }

    public PorukaDtoRequest(String posiljalac, Long idRezervacije, String tekst) {
        this.posiljalac = posiljalac;
        this.idRezervacije = idRezervacije;
        this.tekst = tekst;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public Long getIdRezervacije() {
        return idRezervacije;
    }

    public void setIdRezervacije(Long idRezervacije) {
        this.idRezervacije = idRezervacije;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
