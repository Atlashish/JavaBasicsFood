package com.atlashish.progettojava.service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVExporter {

    public static void exportCSVFiles() throws URISyntaxException {
        try {
            String exportDirectory = System.getProperty("user.dir"); // Ottiene la directory corrente
            
            String[] filesToExport = { "prodotti.csv", "utenti.csv", "vendite.csv" };

            for (String filename : filesToExport) {
                // Ottiene il percorso del file di origine all'interno del JAR
                InputStream inputStream = CSVExporter.class.getResourceAsStream("/" + filename);
                
                if (inputStream != null) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                         FileWriter writer = new FileWriter(new File(exportDirectory, filename))) {
                        
                        String line;
                        while ((line = reader.readLine()) != null) {
                            writer.write(line + "\n");
                        }
                        System.out.println("Esportato il file: " + filename + " in " + exportDirectory);
                    } catch (IOException e) {
                        System.err.println("Errore durante l'esportazione del file " + filename);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Impossibile trovare il file: " + filename);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
