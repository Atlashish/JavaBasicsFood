package com.atlashish.progettojava.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.atlashish.progettojava.model.Prodotti;
import com.atlashish.progettojava.model.Utenti;
import com.atlashish.progettojava.model.Vendite;

public class StampaFile {

 
    //Stampa intestazione della tabella Prodotti
    public static void stampaIntestazioniProdotti() {
        String idColumn = String.format("%s", "ID");
        String nomeColumn = String.format("%-19s", "Nome");
        String dataDiInserimentoColumn = String.format("%-10s", "Data Inserimento");
        String prezzoColumn = String.format("%-7s", "Prezzo");
        String marcaColumn = String.format("%-12s", "Marca");
        String disponibileColumn = String.format("%-2s", "Disp");

        System.out.println("\n-------------------------------- PRODOTTI -----------------------------------");
        System.out.println(idColumn + " | " + nomeColumn + " | " + dataDiInserimentoColumn +
                " | " + prezzoColumn + " | " + marcaColumn + " | " + disponibileColumn + " | ");
        System.out.println("-----------------------------------------------------------------------------");
    }

    // Stampa intestazione della tabella Utenti
    public static void stampaIntestazioniUtenti() {

        String idColumn = String.format("%s", "ID");
        String nomeColumn = String.format("%-9s", "Nome");
        String cognomeColumn = String.format("%-10s", "Cognome");
        String dataDiNascitaColumn = String.format("%-10s", "Data di Nascita");
        String indirizzoColumn = String.format("%-25s", "Indirizzo");
        String documentoIdColumn = String.format("%-10s", "Documento ID");

        System.out.println("\n-------------------------------- UTENTI --------------------------------------------------");
        System.out.println(idColumn + " | " + nomeColumn + " | " + cognomeColumn + " | " 
        + dataDiNascitaColumn + " | " + indirizzoColumn + " | " + documentoIdColumn + " | ");
        System.out.println("------------------------------------------------------------------------------------------");
    }

    // Stampa intestazione della tabella Vendite
    public static void stampaIntestazioniVendite() {

        String idColumn = String.format("%s", "ID");
        String idProdottoColumn = String.format("%s", "ID Prodotto");
        String idUtenteColumn = String.format("%s", "ID Utente");

        System.out.println("\n---------- VENDITE -----------");
        System.out.println(idColumn + " | " + idProdottoColumn + " | " + idUtenteColumn + " | ");
        System.out.println("------------------------------");
    }

    // Stampa i dati del file Prodotti.csv
    public static void caricaProdotti() {
        String filePath = "prodotti.csv";
        boolean isFirstLine = true;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            stampaIntestazioniProdotti(); //Chiama il metodo dell'intestazione dei Prodotti
            String line;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] columns = line.split(";");
                int id = Integer.parseInt(columns[0]);
                String nome = columns[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dataDiInserimento = LocalDate.parse(columns[2], formatter);
                String prezzo = columns[3];
                String marca = columns[4];
                String disponibile = columns[5];

                Prodotti p = new Prodotti(id, nome, dataDiInserimento, prezzo, marca, disponibile);
                System.out.println(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------------------------------------------------------------\n");
    }

    // Stampa i dati del file Utenti.csv
    public static void caricaUtenti() {
        String filePath = "utenti.csv";
        stampaIntestazioniUtenti(); //Chiama il metodo dell'intestazione dei Prodotti
        boolean isFirstLine = true;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] columns = line.split(";");
                int id = Integer.parseInt(columns[0]);
                String nome = columns[1];
                String cognome = columns[2];
                String dataDiNascita = columns[3];
                String indirizzo = columns[4];
                String documentoId = columns[5];

                Utenti u = new Utenti(id, nome, cognome, dataDiNascita, indirizzo, documentoId);
                System.out.println(u);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------------------------------------------------------------------\n");
    }

    // Stampa i dati del file Vendite.csv
    public static void caricaVendite() {
        String filePath = "vendite.csv";
        stampaIntestazioniVendite(); //Chiama il metodo dell'intestazione dei Prodotti
        boolean isFirstLine = true;

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] columns = line.split(";");
                int id = Integer.parseInt(columns[0]);
                int idProdotto = Integer.parseInt(columns[1]);
                int idUtente = Integer.parseInt(columns[2]);

                Vendite v = new Vendite(id, idProdotto, idUtente);
                System.out.println(v);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("------------------------------\n");
    }

}