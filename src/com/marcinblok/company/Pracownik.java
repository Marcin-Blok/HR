package com.marcinblok.company;

public class Pracownik {

    private String imie;
    private String nazwisko;
    private double placa;
    private char plec;
    private int dzial;

    public Pracownik(String imie, String nazwisko, double placa, char plec, int dzial) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.placa = placa;
        this.plec = plec;
        this.dzial = dzial;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getPlaca() {
        return placa;
    }

    public char getPlec() {
        return plec;
    }

    public int getDzial() {
        return dzial;
    }

    boolean czyPracujeWdziale (int dzial){
        return this.dzial == dzial;
    }

    @Override
    public String toString() {
        return "Pracownik{" + imie + " " + nazwisko + " " + placa + " " + plec + " dzial: " + dzial;
    }
}
