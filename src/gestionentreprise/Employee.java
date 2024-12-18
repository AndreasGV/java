package gestionentreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    public static void addEmployee(String nom, String prenom, String poste, String email, String telephone) {
        String query = "INSERT INTO Employes (nom, prenom, poste, email, telephone) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, poste);
            stmt.setString(4, email);
            stmt.setString(5, telephone);
            stmt.executeUpdate();
            System.out.println("Employé ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'employé : " + e.getMessage());
        }
    }

    public static void listEmployees() {
        String query = "SELECT * FROM Employes";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_employe") +
                                   ", Nom: " + rs.getString("nom") +
                                   ", Prénom: " + rs.getString("prenom") +
                                   ", Poste: " + rs.getString("poste") +
                                   ", Email: " + rs.getString("email") +
                                   ", Téléphone: " + rs.getString("telephone"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des employés : " + e.getMessage());
        }
    }

    public static void updateEmployee(int id, String nom, String prenom, String poste, String email, String telephone) {
        String query = "UPDATE Employes SET nom = ?, prenom = ?, poste = ?, email = ?, telephone = ? WHERE id_employe = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, poste);
            stmt.setString(4, email);
            stmt.setString(5, telephone);
            stmt.setInt(6, id);
            stmt.executeUpdate();
            System.out.println("Employé mis à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'employé : " + e.getMessage());
        }
    }

    public static void deleteEmployee(int id) {
        String query = "DELETE FROM Employes WHERE id_employe = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employé supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'employé : " + e.getMessage());
        }
    }
}