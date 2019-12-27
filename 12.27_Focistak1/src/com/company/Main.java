package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final String adatfajl = "c:\\Users\\user\\IdeaProjects\\focistak.txt";
    private final int edzesIdoMax = 10;
    private final int alapFizetes = 40000;
    private final int edzesiHatar = 7;
    private final int edzesiOradij = 1000;
    private final int golHatar = 3;
    private final int jatekDij = 5000;
    private int meccsSzam = 20;
    private double jatekEsely = 0.7;
    private double golEsely = 0.5;

    private List<Focista> focistak = new ArrayList<>();

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        statikusAdatok();
        adatBevitel();
        focistak();
        edzes();
        meccsek();
        eredmenyek();
    }

    private void eredmenyek() {
        System.out.println("\nA meccsek eredménye: ");
        for (Focista focista : focistak) {
            System.out.println(focista.toString());
        }
    }

    private void statikusAdatok() {
        Focista.setAlapFizetes(alapFizetes);
        Focista.setEdzesiHatar(edzesiHatar);
        Focista.setEdzesiOradij(edzesiOradij);
        Focista.setGolHatar(golHatar);
        Focista.setJatekDij(jatekDij);
    }

    //adatok beolvasása:
    private void adatBevitel() {
        try {
            Scanner sc = new Scanner(new File(adatfajl));
            String[] adatok;
            String sor;
            while (sc.hasNextLine()) {
                sor = sc.nextLine();
                if (!sor.isEmpty()) {
                    adatok = sor.split(";");
                    focistak.add(new Focista(adatok[0], Integer.parseInt(adatok[1])));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //kiírjuk a focistákat:
    private void focistak() {
        System.out.println("A focisták:");
        for (Focista focista : focistak) {
            System.out.println(focista.getName());
        }
    }

    //edzések szimulálása:
    private void edzes() {
        for (Focista focista : focistak) {
            int ido = (int) (Math.random() * edzesIdoMax);
            focista.edz(ido);
        }
    }

    //meccsek szimulálása:
    private void meccsek() {
        for (int i = 0; i < meccsSzam; i++) {
            for (Focista focista : focistak) {
                if (Math.random() < jatekEsely) {
                    focista.jatszik();
                    if (Math.random() < golEsely) {
                        focista.goltRug();
                    }
                }
            }
        }
    }


}
