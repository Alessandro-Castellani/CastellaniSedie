package com.mycompany.testgiocosedie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro Castellani
 */

// DICHIARAZIONE CLASSE SCRITTORE, CHE IMPLEMENTA RUNNABLE (E' DUNQUE UN THREAD)
public class Scrittore implements Runnable{

    String nomeFile;
    String messaggio;
    
    /**
     *
     * @param nomeFile
     * @param messaggio
     */
    public Scrittore(String nomeFile, String messaggio){
        this.nomeFile = nomeFile;
        this.messaggio = messaggio;
    }
    
    @Override
    public void run() {
        scrivi();
    }

    public void scrivi(){
        BufferedWriter br = null; // + efficiente. + veloce e - errori
        
        try {
            br = new BufferedWriter(new FileWriter(nomeFile, true)); // il true serve per la funzione di append
            br.write(messaggio);
            br.write("\n\r");
            br.flush(); // Serve a chiudere il buffer e salvarlo. Senza questo comando, il salvataggio sarebbe stato effettuato al br.close()        
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (br!=null)
                try {
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
}
