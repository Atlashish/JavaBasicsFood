package com.atlashish.progettojava;

import java.net.URISyntaxException;

import com.atlashish.progettojava.controller.Controller;
import com.atlashish.progettojava.service.CSVExporter;
import com.atlashish.progettojava.service.StampaFile;

public class Main {

    public static void main(String[] args) throws URISyntaxException {

        CSVExporter.exportCSVFiles();
        Controller.startProgram();
    }
}
