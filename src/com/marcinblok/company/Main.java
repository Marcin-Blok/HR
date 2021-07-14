package com.marcinblok.company;

public class Main {

    public static void main(String[] args) {
        int dzial = 1;
	    Pracownik p = new Pracownik("Marcin" , "Blok", 7800, 'M', 1);
        System.out.println("Czy pracownik pracuje w dziale " + dzial + "? " + p.czyPracujeWdziale(dzial));
    }
}
