package com.atlashish.progettojava.model;

public class Vendite {
    
    private int id;
    private int idProdotto;
    private int idUtente;

    public Vendite(int id, int idProdotto, int idUtente) {
        this.id = id;
        this.idProdotto = idProdotto;
        this.idUtente = idUtente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(int idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public String toString() {
        String idColumn = String.format("%-2s", id);
        String idProdottoColumn = String.format("%-11s", idProdotto);
        String idUtenteColumn = String.format("%-9s", idUtente);


        return String.format("%s | %s | %s |",
                idColumn, idProdottoColumn, idUtenteColumn);
    }
}
