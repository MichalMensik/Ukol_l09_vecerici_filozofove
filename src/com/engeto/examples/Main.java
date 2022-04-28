package com.engeto.examples;

public class Main {

    public static Filozof[] vytvoreniFilozofu(int n) {

        Vidlicka[] vidlicky = new Vidlicka[n];

        for (int i = 0; i < n; i++) {
            vidlicky[i] = new Vidlicka(i);
        }

        Filozof[] filozofove = new Filozof[n];

        for (int i = 0; i < n; i++) {

            Vidlicka levaVidlicka = vidlicky[i];
            Vidlicka pravaVidlicka = vidlicky[(i + 1) % n];

            filozofove[i] = new Filozof(i, levaVidlicka, pravaVidlicka);

        }

        return filozofove;

    }

    public static void main(String[] args) {

        Filozof[] filozofove = vytvoreniFilozofu(10);

        for (Filozof filozof : filozofove) {
            filozof.start();
        }
    }
}
