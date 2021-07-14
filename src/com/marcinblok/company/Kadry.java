package com.marcinblok.company;

import java.io.*;
import java.util.*;

public class Kadry {
    private Pracownik[] pracownicy;
    int zatrudnienie;

    public Kadry() {
        pracownicy = new Pracownik[100];
        zatrudnienie = 0;
    }

    public void dodajPracownika(Pracownik pracownik) {
        if (pracownik != null && zatrudnienie < pracownicy.length) {
            pracownicy[zatrudnienie] = pracownik;
            zatrudnienie++;
        } else {
            System.out.println("Próba dodania pracownika o niewłaściwych danych lub osiągnięto maksymalne dopuszczalne zatrudnienie");
        }
    }

    public void dodajPracownikaInteraktywnie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Aby dodać pracownika, proszę podać imię, nazwisko, płacę, płeć oraz dział");
        System.out.println("Podaj imię pracownika:");
        String imie = sc.next();
        System.out.println("Podaj nazwisko pracownika:");
        String nazwisko = sc.next();
        System.out.println("Podaj płacę:");
        double placa = sc.nextDouble();
        System.out.println("Podaj płeć:");
        char plec = sc.next().charAt(0);
        System.out.println("Podaj dział");
        int dzial = sc.nextInt();
        dodajPracownika(new Pracownik(imie, nazwisko, placa, plec, dzial));
    }

    public double sredniZarobek() {
        double suma = 0;
        for (Pracownik pracownik : pracownicy) {
            if (pracownik != null) {
                suma += pracownik.getPlaca();
            }
        }
        return suma / zatrudnienie;
    }

    public double sredniaPlacaWDziale(int dzial) {
        double suma = 0;
        int liczbaPracownikowDzialu = 0;
        for (Pracownik pracownik : pracownicy) {
            if (pracownik != null && pracownik.czyPracujeWdziale(dzial)) {
                suma += pracownik.getPlaca();
                liczbaPracownikowDzialu++;
            }
        }
        return suma / liczbaPracownikowDzialu;
    }

    public Set<Integer> dajDzialy() {
        Integer[] dzialy = new Integer[zatrudnienie];
        for (int z = 0; z < pracownicy.length && pracownicy[z] != null; z++) {
            dzialy[z] = pracownicy[z].getDzial();
        }
        //Set<Integer> unikalneDzialy = new HashSet<>(Arrays.asList(dzialy));
        // kod powyżej i poniżej komentarza są równoważne(dają taki sam efekt)
        Set<Integer> unikalneDzialy = new HashSet<>();
        Collections.addAll(unikalneDzialy, dzialy);
        return unikalneDzialy;

    }

    public void info() {
        System.out.println("Liczba pracowników w firmie: " + zatrudnienie);
        for (Pracownik pracownik : pracownicy) {
            if (pracownik != null) {
                System.out.println(pracownik);
            }
        }
    }

    public void zapiszDoPliku() {
        for (Pracownik pracownik : pracownicy) {
            FileWriter fileWriter;
            if (pracownik != null) {
                try {
                    fileWriter = new FileWriter("pracownicy.txt", true);
                    BufferedWriter br = new BufferedWriter(fileWriter);
                    br.write(pracownik.toString() + "\n");
                    br.close();

                } catch (IOException e) {
                    System.out.println("Błąd zapisu do pliku");
                }
            }
        }
    }

    public void odczytajZPliku() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("pracownicy.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String pracownik = br.readLine();
            while (pracownik != null) {
                System.out.println(pracownik);
                pracownik = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Błąd podczas próby otwarcia pliku");
        } catch (IOException e) {
            System.out.println("Błąd podczas próby odczytu z pliku");
        }
    }


}
