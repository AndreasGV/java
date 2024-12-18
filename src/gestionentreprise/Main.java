package gestionentreprise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Lister les employés");
            System.out.println("3. Modifier un employé");
            System.out.println("4. Supprimer un employé");
            System.out.println("5. Ajouter un projet");
            System.out.println("6. Lister les projets");
            System.out.println("7. Modifier un projet");
            System.out.println("8. Supprimer un projet");
            System.out.println("9. Assigner un employé à un projet");
            System.out.println("10. Générer un rapport (Projets et employés)");
            System.out.println("11. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1: // Ajouter un employé
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Poste : ");
                    String poste = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();
                    Employee.addEmployee(nom, prenom, poste, email, telephone);
                    break;

                case 2: // Lister les employés
                    Employee.listEmployees();
                    break;

                case 3: // Modifier un employé
                    System.out.print("ID de l'employé à modifier : ");
                    int idEmp = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom : ");
                    String newNom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String newPrenom = scanner.nextLine();
                    System.out.print("Poste : ");
                    String newPoste = scanner.nextLine();
                    System.out.print("Email : ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String newTelephone = scanner.nextLine();
                    Employee.updateEmployee(idEmp, newNom, newPrenom, newPoste, newEmail, newTelephone);
                    break;

                case 4: // Supprimer un employé
                    System.out.print("ID de l'employé à supprimer : ");
                    int idDeleteEmp = scanner.nextInt();
                    Employee.deleteEmployee(idDeleteEmp);
                    break;

                case 5: // Ajouter un projet
                    System.out.print("Titre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Date de début (YYYY-MM-DD) : ");
                    String dateDebut = scanner.nextLine();
                    System.out.print("Date de fin (YYYY-MM-DD) : ");
                    String dateFin = scanner.nextLine();
                    Project.addProject(titre, description, dateDebut, dateFin);
                    break;

                case 6: // Lister les projets
                    Project.listProjects();
                    break;

                case 7: // Modifier un projet
                    System.out.print("ID du projet à modifier : ");
                    int idProjet = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Titre : ");
                    String newTitre = scanner.nextLine();
                    System.out.print("Description : ");
                    String newDescription = scanner.nextLine();
                    System.out.print("Date de début (YYYY-MM-DD) : ");
                    String newDateDebut = scanner.nextLine();
                    System.out.print("Date de fin (YYYY-MM-DD) : ");
                    String newDateFin = scanner.nextLine();
                    Project.addProject(newTitre, newDescription, newDateDebut, newDateFin);
                    break;

                case 8: // Supprimer un projet
                    System.out.print("ID du projet à supprimer : ");
                    int idDeleteProjet = scanner.nextInt();
                    Project.deleteProject(idDeleteProjet);
                    break;

                case 9: // Assigner un employé à un projet
                    System.out.print("ID de l'employé : ");
                    int idEmpAssign = scanner.nextInt();
                    System.out.print("ID du projet : ");
                    int idProjAssign = scanner.nextInt();
                    Project.assignEmployeeToProject(idEmpAssign, idProjAssign);
                    break;

                case 10: // Générer un rapport
                    Report.generateEmployeeProjectReport();
                    break;

                case 11: // Quitter
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}