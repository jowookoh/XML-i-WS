package sesta.projekat.dto;

import java.util.Date;

public class PretragaDto {
    private String lokacija;
    private Date prvi;
    private Date drugi;
    private int brojOsoba;

    public PretragaDto() {
    }

    public PretragaDto(String lokacija, Date prvi, Date drugi, int brojOsoba) {
        this.lokacija = lokacija;
        this.prvi = prvi;
        this.drugi = drugi;
        this.brojOsoba = brojOsoba;
    }

    public String getLokacija() {
        return this.lokacija;
    }

    public void setIdLokacije(String lokacija) {
        this.lokacija = lokacija;
    }

    public Date getPrvi() {
        return prvi;
    }

    public void setPrvi(Date prvi) {
        this.prvi = prvi;
    }

    public Date getDrugi() {
        return drugi;
    }

    public void setDrugi(Date drugi) {
        this.drugi = drugi;
    }

    public int getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(int brojOsoba) {
        this.brojOsoba = brojOsoba;
    }
}
