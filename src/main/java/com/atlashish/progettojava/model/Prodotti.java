package com.atlashish.progettojava.model;

import java.time.LocalDate;

public class Prodotti {
    
    private int id;
    private String nome;
    private LocalDate dataDiInserimento;
    private String prezzo;
    private String marca;
    private String disponibile;

    public Prodotti(int id, String nome, LocalDate dataDiInserimento, String prezzo, String marca, String disponibile) {
        this.id = id;
        this.nome = nome;
        this.dataDiInserimento = dataDiInserimento;
        this.prezzo = prezzo;
        this.marca = marca;
        this.disponibile = disponibile;
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

    public LocalDate getDataDiInserimento() {
        return dataDiInserimento;
    }

    public void setDataDiInserimento(LocalDate dataDiInserimento) {
        this.dataDiInserimento = dataDiInserimento;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(String disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public String toString() {
    String idColumn = String.format("%-1s", id);
    String nomeColumn = String.format("%-20s", nome);
    String dataDiInserimentoColumn = String.format("%-16s", dataDiInserimento);
    String prezzoColumn = String.format("%-7s", prezzo);
    String marcaColumn = String.format("%-12s", marca);
    String disponibileColumn = String.format("%-4s", disponibile);

    return String.format("%s | %s | %s | %s | %s | %s |",
                         idColumn, nomeColumn, dataDiInserimentoColumn,
                         prezzoColumn, marcaColumn, disponibileColumn);
}

    

}
