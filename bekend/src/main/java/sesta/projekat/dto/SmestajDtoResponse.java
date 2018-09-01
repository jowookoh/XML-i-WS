package sesta.projekat.dto;


import java.util.List;

public class SmestajDtoResponse {
    /*slike objekta, opis, cene, ocenu korisnika, kategoriju, sve dodatne pogodnosti, tip objekta*/
    private Long id;
    private List<String> slike;
    private String opis;
    private int cena;
    private String kategorija;
    private String tipSmestaja;
    private List<String> usluge;

    public SmestajDtoResponse() {
    }

    public SmestajDtoResponse(Long id, List<String> slike, String opis, int cena, String kategorija, String tipSmestaja, List<String> usluge) {
        this.id = id;
        this.slike = slike;
        this.opis = opis;
        this.cena = cena;
        this.kategorija = kategorija;
        this.tipSmestaja = tipSmestaja;
        this.usluge = usluge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getSlike() {
        return slike;
    }

    public void setSlike(List<String> slike) {
        this.slike = slike;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getTipSmestaja() {
        return tipSmestaja;
    }

    public void setTipSmestaja(String tipSmestaja) {
        this.tipSmestaja = tipSmestaja;
    }

    public List<String> getUsluge() {
        return usluge;
    }

    public void setUsluge(List<String> usluge) {
        this.usluge = usluge;
    }
}
