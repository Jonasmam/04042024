package org.example;

import java.util.Scanner;

public class MenuGestionVehicules {
    private GestionnaireDB gestionnaireDB;
    private Scanner scanner;

    public MenuGestionVehicules(GestionnaireDB gestionnaireDB) {
        this.gestionnaireDB = gestionnaireDB;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        while (true) {
            System.out.println("Menu Gestion des Véhicules:");
            System.out.println("a. Afficher les véhicules");
            System.out.println("b. Modifier un véhicule");
            System.out.println("c. Ajouter un véhicule");
            System.out.println("d. Supprimer un véhicule");
            System.out.println("e. Afficher les véhicules d’un âge donné");
            System.out.println("f. Afficher les véhicules dont le prix est compris entre un prix minimal et un prix maximal");
            System.out.println("q. Quitter");
            System.out.print("Choix : ");

            String choix = scanner.nextLine().trim().toLowerCase();
            switch (choix) {
                case "a":
                    gestionnaireDB.afficherVehicules();
                    break;
                case "b":
                    // Appeler la méthode pour modifier un véhicule dans le gestionnaireDB
                    break;
                case "c":
                    // Appeler la méthode pour ajouter un véhicule dans le gestionnaireDB
                    break;
                case "d":
                    // Appeler la méthode pour supprimer un véhicule dans le gestionnaireDB
                    break;
                case "e":
                    // Appeler la méthode pour afficher les véhicules d’un âge donné dans le gestionnaireDB
                    break;
                case "f":
                    // Appeler la méthode pour afficher les véhicules dont le prix est compris entre un prix minimal et un prix maximal dans le gestionnaireDB
                    break;
                case "q":
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
}
