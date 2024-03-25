package com.atlashish.progettojava.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.atlashish.progettojava.model.Prodotti;
import com.atlashish.progettojava.model.Utenti;
import com.atlashish.progettojava.model.Vendite;

public class ScritturaFile {
    
    // Metodo per scrivere le vendite su un file CSV
    protected static void scriviVendite(Map<Integer, Vendite> venditeMap) {
        String filePath = "vendite.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID;ID Prodotto;ID Utente\n");
            for (Vendite vendita : venditeMap.values()) {
                writer.write(String.format("%d;%d;%d\n", vendita.getId(), vendita.getIdProdotto(), vendita.getIdUtente()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo per scrivere i prodotti su un file CSV
    protected static void scriviProdotti(Map<Integer, Prodotti> prodottiMap) {
        String filePath = "prodotti.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID;Nome;Data di inserimento;Prezzo;Marca;Disponibile\n");
            for (Prodotti prodotto : prodottiMap.values()) {
                writer.write(String.format("%d;%s;%s;%s;%s;%s\n", prodotto.getId(), prodotto.getNome(),
                        prodotto.getDataDiInserimento(),
                        prodotto.getPrezzo(), prodotto.getMarca(), prodotto.getDisponibile()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo per scrivere gli utenti su un file CSV
    protected static void scriviUtenti(Map<Integer, Utenti> utentiMap) {
        String filePath = "utenti.csv";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID;Nome;Cognome;Data di nascita;Indirizzo;Documento ID\n");
            for (Utenti utente : utentiMap.values()) {
                writer.write(String.format("%d;%s;%s;%s;%s;%s\n", utente.getId(), utente.getNome(), utente.getCognome(),
                        utente.getDataDiNascita(), utente.getIndirizzo(), utente.getDocumentoId()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
