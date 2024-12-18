package gestionentreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Project {
    public static void addProject(String titre, String description, String dateDebut, String dateFin) {
        String query = "INSERT INTO Projets (titre, description, date_debut, date_fin) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, titre);
            stmt.setString(2, description);
            stmt.setString(3, dateDebut);
            stmt.setString(4, dateFin);
            stmt.executeUpdate();
            System.out.println("Projet ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du projet : " + e.getMessage());
        }
    }

    public static void listProjects() {
        String query = "SELECT * FROM Projets";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_projet") +
                                   ", Titre: " + rs.getString("titre") +
                                   ", Description: " + rs.getString("description") +
                                   ", Date Début: " + rs.getDate("date_debut") +
                                   ", Date Fin: " + rs.getDate("date_fin"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des projets : " + e.getMessage());
        }
    }

    public static void deleteProject(int id) {
        String query = "DELETE FROM Projets WHERE id_projet = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Projet supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression du projet : " + e.getMessage());
        }
    }

    public static void assignEmployeeToProject(int employeeId, int projectId) {
        String query = "INSERT INTO Employe_Projet (id_employe, id_projet) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, employeeId);
            stmt.setInt(2, projectId);
            stmt.executeUpdate();
            System.out.println("Employé assigné au projet avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'assignation de l'employé au projet : " + e.getMessage());
        }
    }
}