package com.engeto.examples;

public class Filozof extends Thread {

    private final int id;
    private final Vidlicka levaVidlicka;
    private final Vidlicka pravaVidlicka;

    public Filozof(int id, Vidlicka levaVidlicka, Vidlicka pravaVidlicka) {
        this.id = id;
        this.levaVidlicka = levaVidlicka;
        this.pravaVidlicka = pravaVidlicka;
    }

    @Override
    public void run() {
        for (;;) {
            System.out.println("Filozof " + id + " přemýšlí...");
            if (id % 2 == 0) {
                levaVidlicka.take(id);
                System.out.println("Filozof " + id + " vzal levou vidličku " + levaVidlicka.id);
                pravaVidlicka.take(id);
                System.out.println("Filozof " + id + " vzal pravou vidličku " + pravaVidlicka.id);
            }
            else {
                pravaVidlicka.take(id);
                System.out.println("Filozof " + id + " vzal pravou vidličku " + pravaVidlicka.id);
                levaVidlicka.take(id);
                System.out.println("Filozof " + id + " vzal levou vidličku " + levaVidlicka.id);
            }
            System.out.println("Filozof " + id + " jí...");
            levaVidlicka.put(id);
            System.out.println("Filozof " + id + " odložil levou vidličku " + levaVidlicka.id);
            pravaVidlicka.put(id);
            System.out.println("Filozof " + id + " odložil pravou vidličku " + pravaVidlicka.id);

        }
    }
}
