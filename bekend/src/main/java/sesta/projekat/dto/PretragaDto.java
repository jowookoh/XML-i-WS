package sesta.projekat.dto;

import java.util.Date;

public class PretragaDto {
    private Long idLokacije;
    private Date prvi;
    private Date drugi;
    private int brojOsoba;

    public PretragaDto() {
    }

    public PretragaDto(Long idLokacije, Date prvi, Date drugi, int brojOsoba) {
        this.idLokacije = idLokacije;
        this.prvi = prvi;
        this.drugi = drugi;
        this.brojOsoba = brojOsoba;
    }

    public Long getIdLokacije() {
        return idLokacije;
    }

    public void setIdLokacije(Long idLokacije) {
        this.idLokacije = idLokacije;
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
