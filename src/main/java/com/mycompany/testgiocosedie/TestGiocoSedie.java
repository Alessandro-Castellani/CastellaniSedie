package com.mycompany.testgiocosedie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alessandro Castellani
 */

// DICHIARAZIONE CLASSE TESTGIOCOSEDIE
public class TestGiocoSedie {

    private static final Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     *
     * @param args
     */
    
    // METODO MAIN
    public static void main(String[] args) {
           
        int numeroPartecipanti = 0;

        // Output all'utente in cui si richiede quanti partecipanti desidera avere e successiva lettura del valore inserito
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Inserisci il numero di partecipanti: ");
            numeroPartecipanti = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Errore durante l'inserimento del numero di partecipanti", e);
            return;
        }
       
        // Calcolo del numero di sedie (che equivalgono ai partecipanti -1)
        int NUMSEDIE = numeroPartecipanti - 1;

        Posto sedie[] = new Posto[NUMSEDIE];
	for (int k = 0; k < sedie.length; k++)
		sedie[k] = new Posto();

        // Dichiarazione del Display e suo avvio attraverso il metodo Start() della classe Thread
	Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
	display.start();

        // Dichiarazione di array[], array di partecipanti, e suo avvio attraverso il metodo Start() della classe Thread
	Partecipante array[] = new Partecipante[NUMSEDIE+1];
	for (int i = 0; i < NUMSEDIE + 1; i++) {
            array[i] = new Partecipante(sedie);
            logger.log(Level.INFO, "Sto facendo partire il thread id: {0} name: {1}\n", new Object[]{array[i].getId(), array[i].getName()});
            array[i].start();
        
            // Dichiarazione dello Scrittore e suo avvio attraverso il metodo Start() della classe Thread
            Scrittore scrittore = new Scrittore("Risultato.txt", array[i].getName());
            new Thread(scrittore).start(); 
        }
    }
}
