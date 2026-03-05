package com.example.demo1;

public class Ukol {
    private String nazevUkolu;
    private String predmet;
    private String priorita;
    private String splneno;
    Ukol(String nazevUkolu, String predmet, String priorita, String splneno) {
        this.nazevUkolu = nazevUkolu;
        this.predmet = predmet;
        this.priorita = priorita;
        this.splneno = splneno;
    }

    public String getNazevUkolu() {
        return nazevUkolu;
    }

    public void setNazevUkolu(String nazevUkolu) {
        this.nazevUkolu = nazevUkolu;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public String getPriorita() {
        return priorita;
    }

    public void setPriorita(String priorita) {
        this.priorita = priorita;
    }

    public String getSplneno() {
        return splneno;
    }

    public void setSplneno(String splneno) {
        this.splneno = splneno;
    }

    @Override
    public String toString() {
        return nazevUkolu;
    }
}
