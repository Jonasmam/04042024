package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        LecteurFichier lecteurFichier = new LecteurFichier();
        lecteurFichier.afficherVehicules();
        lecteurFichier.afficherVehiculesMoins20AnsEtInserer();
        GestionnaireDB gestionnaireDB = new GestionnaireDB();
        MenuGestionVehicules menu = new MenuGestionVehicules(gestionnaireDB);
        menu.afficherMenu();
    }
}

