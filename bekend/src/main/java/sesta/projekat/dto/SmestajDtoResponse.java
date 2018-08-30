package sesta.projekat.dto;


import java.util.List;

public class SmestajDtoResponse {
    /*slike objekta, opis, cene, ocenu korisnika, kategoriju, sve dodatne pogodnosti, tip objekta*/
    private List<String> slike;
    private String opis;
    private List<CenaDto> cene;
    private String kategorija;
    private String tipSmestaja;
    private List<String> usluge;

    public SmestajDtoResponse() {
    }

    public SmestajDtoResponse(List<String> slike, String opis, List<CenaDto> cene, String kategorija, String tipSmestaja, List<String> usluge) {
        this.slike = slike;
        this.opis = opis;
        this.cene = cene;
        this.kategorija = kategorija;
        this.tipSmestaja = tipSmestaja;
        this.usluge = usluge;
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

    public List<CenaDto> getCene() {
        return cene;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public void setCene(List<CenaDto> cene) {
        this.cene = cene;
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
