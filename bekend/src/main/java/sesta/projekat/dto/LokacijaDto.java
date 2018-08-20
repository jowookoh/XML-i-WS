package sesta.projekat.dto;

public class LokacijaDto {
    private Long id;

    private String drzava;

    private String mesto;

    public LokacijaDto() {
    }

    public LokacijaDto(Long id, String drzava, String mesto) {
        this.id = id;
        this.drzava = drzava;
        this.mesto = mesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }
}
