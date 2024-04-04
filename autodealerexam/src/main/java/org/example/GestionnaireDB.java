package org.example;

import java.sql.*;
import java.util.Calendar;

public class GestionnaireDB {
    private static final String URL = "jdbc:mysql://localhost:3306/auto_dealer";
    private static final String UTILISATEUR = "root";
    private static final String MOT_DE_PASSE = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement du pilote JDBC : " + e.getMessage());
        }
    }

    public static void insererVehicule(String immatriculation, String marque, String modele, int annee, double prix) {
        try (Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            String sql = "INSERT INTO car (registration_number, brand, model, date_of_first_registration, price) VALUES (?, ?, ?, STR_TO_DATE(?, '%Y'), ?)";
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);
            preparedStatement.setString(1, immatriculation);
            preparedStatement.setString(2, marque);
            preparedStatement.setString(3, modele);
            preparedStatement.setString(4, String.valueOf(annee)); // Utilisation de STR_TO_DATE pour formater l'année
            preparedStatement.setDouble(5, prix);
            preparedStatement.executeUpdate();
            System.out.println("Véhicule inséré avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion du véhicule : " + e.getMessage());
        }
    }


    public void afficherVehicules() {
        try (Connection connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE)) {
            String requete = "SELECT * FROM car";
            Statement statement = connexion.createStatement();
            ResultSet resultats = statement.executeQuery(requete);

            while (resultats.next()) {
                String immatriculation = resultats.getString("registration_number");
                String marque = resultats.getString("brand");
                String modele = resultats.getString("model");
                Date dateImmatriculation = resultats.getDate("date_of_first_registration");
                double prix = resultats.getDouble("price");

                System.out.println(immatriculation + " - " + marque + " - " + modele + " - Date d'immatriculation: " + dateImmatriculation + " - Prix: " + prix);
            }

            resultats.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des véhicules : " + e.getMessage());
        }
    }
}


