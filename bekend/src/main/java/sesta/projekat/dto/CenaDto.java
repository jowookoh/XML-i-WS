package sesta.projekat.dto;

import java.util.Date;
import java.util.List;

public class CenaDto {
    private Date mesec;
    private int vrednost;

    public CenaDto() {
    }

    public CenaDto(Date mesec, int vrednost) {
        this.mesec = mesec;
        this.vrednost = vrednost;
    }

    public Date getMesec() {
        return mesec;
    }

    public void setMesec(Date mesec) {
        this.mesec = mesec;
    }

    public int getVrednost() {
        return vrednost;
    }

    public void setVrednost(int vrednost) {
        this.vrednost = vrednost;
    }

}
