package sesta.projekat.dto;

public class SmestajDto {

    private Long id;
    private String opis;
    private TipSmestajaDto tipSmestajaDto;
    private KategorijaSmestajaDto kategorijaSmestajaDto;
    private LokacijaDto lokacijaDto;
    private int brojOsoba;

    public SmestajDto() {
    }

    public SmestajDto(Long id, String opis, TipSmestajaDto tipSmestajaDto, KategorijaSmestajaDto kategorijaSmestajaDto, LokacijaDto lokacijaDto, int brojOsoba) {
        this.id = id;
        this.opis = opis;
        this.tipSmestajaDto = tipSmestajaDto;
        this.kategorijaSmestajaDto = kategorijaSmestajaDto;
        this.lokacijaDto = lokacijaDto;
        this.brojOsoba = brojOsoba;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public TipSmestajaDto getTipSmestajaDto() {
        return tipSmestajaDto;
    }

    public void setTipSmestajaDto(TipSmestajaDto tipSmestajaDto) {
        this.tipSmestajaDto = tipSmestajaDto;
    }

    public KategorijaSmestajaDto getKategorijaSmestajaDto() {
        return kategorijaSmestajaDto;
    }

    public void setKategorijaSmestajaDto(KategorijaSmestajaDto kategorijaSmestajaDto) {
        this.kategorijaSmestajaDto = kategorijaSmestajaDto;
    }

    public LokacijaDto getLokacijaDto() {
        return lokacijaDto;
    }

    public void setLokacijaDto(LokacijaDto lokacijaDto) {
        this.lokacijaDto = lokacijaDto;
    }

    public int getBrojOsoba() {
        return brojOsoba;
    }

    public void setBrojOsoba(int brojOsoba) {
        this.brojOsoba = brojOsoba;
    }
}

