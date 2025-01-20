package com.mycompany.testgiocosedie;

class Partecipante extends Thread {
    Posto sedie[];

    public Partecipante(Posto sedie[]) {
        this.sedie = sedie;
    }

    @Override
    public void run() {
        try {
            boolean posto = false;
            sleep((int) (Math.random() * 1000));
            
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + i);
                    posto = true;
                    break;
                }
            }

            Scrittore scrittore;
            if (posto) {
                scrittore = new Scrittore("Risultato.txt", "Thread " + this.getName() + " ha vinto!");
            } else {
                scrittore = new Scrittore("Risultato.txt", "Thread " + this.getName() + " ha perso :((((");
            }

            new Thread(scrittore).start(); 

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }    
    }
}