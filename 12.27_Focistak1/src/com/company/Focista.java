package com.company;

public class Focista {

    private String name;
    private int igazolasSzam;

    private int edzesIdo;
    private int meccsekSzama;
    private int golokSzama;

    private static int alapFizetes;
    private static int edzesiHatar;
    private static int edzesiOradij;
    private static int golHatar;
    private static int jatekDij;

    public Focista(String nev, int igazolasSzam) {
        this.name = nev;
        this.igazolasSzam = igazolasSzam;
    }

    public static void setAlapFizetes(int alapFizetes) {
        Focista.alapFizetes = alapFizetes;
    }
    public static void setEdzesiHatar(int edzesiHatar) {
        Focista.edzesiHatar = edzesiHatar;
    }
    public static void setEdzesiOradij(int edzesiOradij) {
        Focista.edzesiOradij = edzesiOradij;
    }
    public static void setGolHatar(int golHatar) {
        Focista.golHatar = golHatar;
    }
    public static void setJatekDij(int jatekDij) {
        Focista.jatekDij = jatekDij;
    }

    public String getName() {
        return name;
    }
    public int getIgazolasSzam() {
        return igazolasSzam;
    }
    public int getEdzesIdo() {
        return edzesIdo;
    }
    public int getMeccsekSzama() {
        return meccsekSzama;
    }
    public int getGolokSzama() {
        return golokSzama;
    }

    public static int getAlapFizetes() {
        return alapFizetes;
    }
    public static int getEdzesiHatar() {
        return edzesiHatar;
    }
    public static int getEdzesiOradij() {
        return edzesiOradij;
    }
    public static int getGolHatar() {
        return golHatar;
    }
    public static int getJatekDij() {
        return jatekDij;
    }

    public void edz(int ido) {
        this.edzesIdo += ido;
    }
    public void jatszik() {
        this.meccsekSzama++;
    }
    public void goltRug() {
        this.golokSzama++;
    }

    public int fizetes() {
        int temp = Focista.alapFizetes;
        if (this.edzesIdo >= Focista.edzesiHatar) {
            temp += this.edzesIdo * Focista.edzesiOradij;
        }
        if (this.golokSzama >= Focista.golHatar) {
            temp += this.meccsekSzama * Focista.jatekDij;
        }
        return temp;
    }

    @Override
    public String toString() {
        return name + " ebben a szezonban \n\t\t"
                + this.getEdzesIdo() + " órát edzett, \n\t\t"
                + this.getMeccsekSzama() + " meccsen játszott, \n\t\t"
                + this.getGolokSzama() + " gólt rúgott, \n\t\t"
                + this.fizetes() + " Forintot keresett.";
    }
}
