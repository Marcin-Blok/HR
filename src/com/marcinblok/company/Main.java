package com.marcinblok.company;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Kadry kadry = new Kadry();
        int dzial = 2;
        //kadry.dodajPracownikaInteraktywnie();
        kadry.dodajPracownika(new Pracownik("Marcin" , "Blok", 7800, 'M', 1));
        kadry.dodajPracownika(new Pracownik("Kuba" , "Bielach", 4300, 'M', 1));
        kadry.dodajPracownika(new Pracownik("Anna" , "Sroka", 5200, 'K', 1));
        kadry.dodajPracownika(new Pracownik("Paulina" , "Wiśniewska", 6150, 'K', 2));
        kadry.dodajPracownika(new Pracownik("Szymon" , "Kowal", 8900, 'M', 2));
        System.out.printf("Średni zarobek w firmie wynosi: %.2f%s",  kadry.sredniZarobek() , "zł.");
        System.out.printf("\nŚrednia płaca w dziale %d%s %.2f%s" , dzial , " wynosi:" , kadry.sredniaPlacaWDziale(dzial) , "zł.");
        System.out.println();
        kadry.info();
        System.out.println("Aktualne działy: " + kadry.dajDzialy());
        //kadry.zapiszDoPliku();
        kadry.odczytajZPliku();



    }
}
