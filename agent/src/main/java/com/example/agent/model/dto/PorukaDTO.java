package com.example.agent.model.dto;

import com.example.agent.model.Rezervacija;

public class PorukaDTO {
        private Long id;

        private Long posiljalacId;

        private Rezervacija rezervacija;

        private String tekst;

        public PorukaDTO() {
        }

        public PorukaDTO(Long id, Long posiljalacId, Rezervacija rezervacija, String tekst) {
            this.id = id;
            this.posiljalacId = posiljalacId;
            this.rezervacija = rezervacija;
            this.tekst = tekst;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getPosiljalacId() {
            return posiljalacId;
        }

        public void setPosiljalacId(Long posiljalacId) {
            this.posiljalacId = posiljalacId;
        }

        public Rezervacija getRezervacija() {
            return rezervacija;
        }

        public void setRezervacija(Rezervacija rezervacijaId) {
            this.rezervacija = rezervacijaId;
        }

        public String getTekst() {
            return tekst;
        }

        public void setTekst(String tekst) {
            this.tekst = tekst;
        }
}
