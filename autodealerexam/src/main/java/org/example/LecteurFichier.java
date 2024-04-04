package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import org.example.GestionnaireDB;

public class LecteurFichier {
    public void afficherVehicules() {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jmamola\\IdeaProjects\\autodealerexam\\src\\data.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public void afficherVehiculesMoins20AnsEtInserer() {
        Calendar maintenant = Calendar.getInstance();
        int anneeActuelle = maintenant.get(Calendar.YEAR);

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jmamola\\IdeaProjects\\autodealerexam\\src\\data.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] champs = ligne.split(",");
                int anneeVehicule = Integer.parseInt(champs[3].split("/")[2]);
                if (anneeActuelle - anneeVehicule < 20) {
                    System.out.println(ligne); // Affiche les véhicules de moins de 20 ans
                    GestionnaireDB gestionnaireDB;
                    GestionnaireDB.insererVehicule(champs[0], champs[1], champs[2], anneeVehicule, Double.parseDouble(champs[4]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
