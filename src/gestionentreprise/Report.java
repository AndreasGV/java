package gestionentreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Report {
    public static void generateEmployeeProjectReport() {
        String query = "SELECT e.nom, e.prenom, p.titre " +
                       "FROM Employe_Projet ep " +
                       "JOIN Employes e ON ep.id_employe = e.id_employe " +
                       "JOIN Projets p ON ep.id_projet = p.id_projet";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("Employé: " + rs.getString("nom") + " " + rs.getString("prenom") +
                                   ", Projet: " + rs.getString("titre"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la génération du rapport : " + e.getMessage());
        }
    }
}