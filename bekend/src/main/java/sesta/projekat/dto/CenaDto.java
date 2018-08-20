package sesta.projekat.dto;

import java.util.Date;

public class CenaDto {
    private Long id;

    private SmestajDto smestajDto;

    private Date mesec;

    public CenaDto() {
    }

    public CenaDto(Long id, SmestajDto smestajDto, Date mesec) {
        this.id = id;
        this.smestajDto = smestajDto;
        this.mesec = mesec;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SmestajDto getSmestajDto() {
        return smestajDto;
    }

    public void setSmestajDto(SmestajDto smestajDto) {
        this.smestajDto = smestajDto;
    }

    public Date getMesec() {
        return mesec;
    }

    public void setMesec(Date mesec) {
        this.mesec = mesec;
    }
}
