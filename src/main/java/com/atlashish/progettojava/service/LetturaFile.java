package com.atlashish.progettojava.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.atlashish.progettojava.model.Prodotti;
import com.atlashish.progettojava.model.Utenti;
import com.atlashish.progettojava.model.Vendite;

public class LetturaFile {

    // Metodo per caricare i prodotti da un file CSV in un'HashMap
    protected static Map<Integer, Prodotti> caricaProdotti(Prodotti p, Map<Integer, Prodotti> prodottiMap) {
        String filePath = "prodotti.csv";
        prodottiMap = new HashMap<>();
    
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true;
    
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
    
                p = new Prodotti(id, nome, dataDiInserimento, prezzo, marca, disponibile);
                prodottiMap.put(id, p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prodottiMap;
    }
    
    protected static Map<Integer, Utenti> caricaUtenti(Utenti u, Map<Integer, Utenti> utentiMap) {
        String filePath = "utenti.csv";
        utentiMap = new HashMap<>();
    
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true;
    
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
    
                u = new Utenti(id, nome, cognome, dataDiNascita, indirizzo, documentoId);
                utentiMap.put(id, u);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return utentiMap;
    }
    
    protected static Map<Integer, Vendite> caricaVendite(Vendite v, Map<Integer, Vendite> venditeMap) {
        String filePath = "vendite.csv";
        venditeMap = new HashMap<>();
    
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true;
    
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
    
                String[] columns = line.split(";");
                int id = Integer.parseInt(columns[0]);
                int idProdotto = Integer.parseInt(columns[1]);
                int idUtente = Integer.parseInt(columns[2]);
    
                v = new Vendite(id, idProdotto, idUtente);
                venditeMap.put(id, v);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return venditeMap;
    }
    

}

