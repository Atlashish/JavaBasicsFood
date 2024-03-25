package com.atlashish.progettojava.model;

public class Utenti {

    private int id;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String indirizzo;
    private String documentoId;

    public Utenti(int id, String nome, String cognome, String dataDiNascita, String indirizzo, String documentoId) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.indirizzo = indirizzo;
        this.documentoId = documentoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    @Override
    public String toString() {
        String idColumn = String.format("%-1s", id);
        String nomeColumn = String.format("%-10s", nome);
        String cognomeColumn = String.format("%-10s", cognome);
        String dataDiNascitaColumn = String.format("%-15s", dataDiNascita);
        String indirizzoColumn = String.format("%-25s", indirizzo);
        String documentoIdColumn = String.format("%-12s", documentoId);

        return String.format("%s | %s | %s | %s | %s | %s |",
                idColumn, nomeColumn, cognomeColumn,
                dataDiNascitaColumn, indirizzoColumn, documentoIdColumn);
    }

}
