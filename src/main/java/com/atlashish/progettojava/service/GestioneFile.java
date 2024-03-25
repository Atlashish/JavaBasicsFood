package com.atlashish.progettojava.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

import com.atlashish.progettojava.model.Prodotti;
import com.atlashish.progettojava.model.Utenti;
import com.atlashish.progettojava.model.Vendite;

public class GestioneFile {

    // Dichiarazioni di variabili di classe
    private static Prodotti p;
    private static Vendite v;
    private static Utenti u;
    private static Map<Integer, Prodotti> prodottiMap;
    private static Map<Integer, Utenti> utentiMap;
    private static Map<Integer, Vendite> venditeMap;

    // Metodo per l'acquisto di un prodotto
    public static void acquistaProdotto(Scanner sc) {
        // Carica le informazioni sui prodotti, utenti e vendite dai file
        prodottiMap = LetturaFile.caricaProdotti(p, prodottiMap);
        utentiMap = LetturaFile.caricaUtenti(u, utentiMap);
        venditeMap = LetturaFile.caricaVendite(v, venditeMap);

        System.out.println("Inserisci l'id del prodotto da acquistare (0 per uscire): ");
        int idProdotto = sc.nextInt();
        if (idProdotto == 0) {
            return;
        }
        if (!prodottiMap.containsKey(idProdotto)) {
            System.out.println("Prodotto non trovato");
            return;
        }
        Prodotti prodottoSelezionato = prodottiMap.get(idProdotto);
        if (prodottoSelezionato.getDisponibile().equals("NO")) {
            System.out.println("Prodotto non disponibile");
            return;
        }
        System.out.println("Inserisci l'id dell'utente da cui acquistare il prodotto (0 per uscire): ");
        int idUtente = sc.nextInt();
        if (idUtente == 0) {
            return;
        }
        if (!utentiMap.containsKey(idUtente)) {
            System.out.println("Utente non trovato");
            return;
        }
        int maxVenditaId = 0;
        for (int venditaId : venditeMap.keySet()) {
            maxVenditaId = Math.max(maxVenditaId, venditaId);
        }
        int nuovoIdVendita = maxVenditaId + 1;
        Vendite nuovaVendita = new Vendite(nuovoIdVendita, idProdotto, idUtente);
        venditeMap.put(nuovoIdVendita, nuovaVendita);
        prodottoSelezionato.setDisponibile("NO");
        ScritturaFile.scriviVendite(venditeMap);
        ScritturaFile.scriviProdotti(prodottiMap);
        StampaFile.caricaVendite();
        System.out.println("Prodotto acquistato con successo");
    }

    // Metodo per la restituzione di un prodotto
    public static void resoProdotto(Scanner sc) {
        prodottiMap = LetturaFile.caricaProdotti(p, prodottiMap);
        venditeMap = LetturaFile.caricaVendite(v, venditeMap);

        System.out.println("Inserisci l'ID della vendita da restituire (0 per uscire): ");
        int idVendita = sc.nextInt();
        if (idVendita == 0) {
            return;
        }
        if (!venditeMap.containsKey(idVendita)) {
            System.out.println("Vendita non trovata");
            return;
        }

        Vendite venditaDaRestituire = venditeMap.get(idVendita);
        int idProdotto = venditaDaRestituire.getIdProdotto();

        if (!prodottiMap.containsKey(idProdotto)) {
            System.out.println("Prodotto associato non trovato");
            return;
        }

        Prodotti prodottoDaRestituire = prodottiMap.get(idProdotto);
        prodottoDaRestituire.setDisponibile("SI");

        venditeMap.remove(idVendita);
        ScritturaFile.scriviVendite(venditeMap);
        ScritturaFile.scriviProdotti(prodottiMap);
        StampaFile.caricaVendite();
        System.out.println("Prodotto restituito con successo");
    }

    // Metodo per aggiungere un nuovo utente
    public static void aggiungiUtente(Scanner sc) {

        utentiMap = LetturaFile.caricaUtenti(u, utentiMap);
        System.out.println("Inserisci l'ID dell'utente da aggiungere (0 per uscire): ");
        int idUtente = sc.nextInt();
        if (idUtente == 0) {
            return;
        }
        sc.nextLine();
        if (utentiMap.containsKey(idUtente)) {
            System.out.println("Utente esistente");
            return;
        }
        System.out.println("Inserisci il nome dell'utente da aggiungere (0 per uscire): ");
        String nomeUtente = sc.next();
        if (nomeUtente.equals("0")) {
            return;
        }
        System.out.println("Inserisci il cognome dell'utente da aggiungere (0 per uscire): ");
        String cognomeUtente = sc.next();
        if (cognomeUtente.equals("0")) {
            return;
        }
        System.out.println("Inserisci la data di nascita dell'utente da aggiungere (dd/mm/yyyy) (0 per uscire): ");
        String dataDiNascitaUtente = sc.next();
        if (dataDiNascitaUtente.equals("0")) {
            return;
        }
        sc.nextLine();

        System.out.println("Inserisci l'indirizzo dell'utente da aggiungere (0 per uscire): ");
        String indirizzoUtente = sc.nextLine();
        if (indirizzoUtente.equals("0")) {
            return;
        }

        System.out.println("Inserisci il documento ID dell'utente da aggiungere (0 per uscire): ");
        String documentoIdUtente = sc.nextLine();
        if (documentoIdUtente.equals("0")) {
            return;
        }

        Utenti nuovoUtente = new Utenti(idUtente, nomeUtente, cognomeUtente, dataDiNascitaUtente, indirizzoUtente,
                documentoIdUtente);
        utentiMap.put(idUtente, nuovoUtente);
        ScritturaFile.scriviUtenti(utentiMap);
        StampaFile.caricaUtenti();
        System.out.println("Utente aggiunto con successo");
    }

    //metodo per esportare i prodotti in un file .csv
    public static void esportaFile() {
        prodottiMap = LetturaFile.caricaProdotti(p, prodottiMap);
        String fileName = "prodotti_" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy")) + ".csv";
        String filePath = new File(fileName).getAbsolutePath();

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))) {
            writer.println("ID;Nome;Data di Inserimento;Prezzo;Marca");
            for (Prodotti prodotto : prodottiMap.values()) {
                if (prodotto.getDisponibile().equals("SI")) {
                    writer.printf("%d;%s;%s;%s;%s%n",
                            prodotto.getId(),
                            prodotto.getNome(),
                            prodotto.getDataDiInserimento(),
                            prodotto.getPrezzo(),
                            prodotto.getMarca());
                }
            }
            System.out.println("File CSV esportato con successo: " + filePath);
        } catch (IOException e) {
            System.err.println("Errore durante l'esportazione del file CSV: " + e.getMessage());
        }
    }

}
