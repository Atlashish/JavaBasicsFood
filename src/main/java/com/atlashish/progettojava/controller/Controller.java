package com.atlashish.progettojava.controller;

import java.util.Scanner;

import com.atlashish.progettojava.service.GestioneFile;
import com.atlashish.progettojava.service.StampaFile;

public class Controller {

    public static void startProgram() {
        boolean continua = true;
        Scanner sc = new Scanner(System.in);

        while (continua) {
            switch (stampaComandi(sc)) {
                case 0: //Esci dal programma
                    continua = false;
                    System.out.println("\nSei uscito dal programma. Alla prossima!\n");
                    break;
                case 1: //Carica i prodotti
                    StampaFile.caricaProdotti();
                    break;
                case 2: //Compra un prodotto
                    StampaFile.caricaProdotti();
                    StampaFile.caricaUtenti();
                    GestioneFile.acquistaProdotto(sc);
                    break;
                case 3: //Restituisci un prodotto
                    StampaFile.caricaVendite();
                    GestioneFile.resoProdotto(sc);
                    break;
                case 4: //Aggiungi un nuovo utente
                    StampaFile.caricaUtenti();
                    GestioneFile.aggiungiUtente(sc);
                    break;
                case 5: //Esporta un file
                    GestioneFile.esportaFile();
                    break;
                default: //Scelta non valida
                    System.out.println();
                    System.out.println("Scelta non valida. Riprova.");
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }

    // Stampa i comandi
    public static int stampaComandi(Scanner sc) {
        System.out.println();
        System.out.println("Tasto \"1\": Carica i prodotti");
        System.out.println("Tasto \"2\": Compra un prodotto esistente");
        System.out.println("Tasto \"3\": Restituisci un prodotto");
        System.out.println("Tasto \"4\": Aggiungi un nuovo utente");
        System.out.println("Tasto \"5\": Esporta un file con i prodotti disponibili");
        System.out.println("Tasto \"0\": Esci dal programma");
        System.out.println();
        System.out.println("Cosa vuoi fare?");
        int code = sc.nextInt();
        return code;
    }
}