package com.engeto.examples;

public class Vidlicka {

    public final int id;
    private boolean vidlickaJeNaStole = true;
    private int pouzivanaVidlicka;

    public Vidlicka(int id) {
        this.id = id;
    }

    public synchronized void take(int filozof) {

        while (!vidlickaJeNaStole) {
            try {
                wait();
            }
            catch (InterruptedException ignored) {}
        }

        pouzivanaVidlicka = filozof;

        vidlickaJeNaStole = false;

    }

    public synchronized void put(int filozof) {

        if (!vidlickaJeNaStole && pouzivanaVidlicka == filozof) {
            vidlickaJeNaStole = true;
            notify();
        }

    }

}

