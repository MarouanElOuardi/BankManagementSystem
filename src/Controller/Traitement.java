package Controller;

import Model.*;
import Service.ServiceBanque;
import View.console.Menu;

import java.util.Scanner;

public class Traitement {
    private ServiceBanque sb;
    private Auth auth;
    private Menu menu;
    private Banque banque;
    Traitement(){
        this.banque=new Banque("Agence EMSI", "Agence@Emsi.com");
        this.sb=new ServiceBanque(banque);
        this.auth=new Auth(banque);
    }
    int begin() throws InterruptedException {
        Client c1 = new Client("Cj", "Pinky", "CjPinky@Emsi.com");
        Compte cp1 = new Compte(1000, c1);
        Compte cp2 = new Compte(2000, c1);
        banque.set1client(c1);
        banque.set1compte(cp1);
        banque.set1compte(cp2);
        Auth auth = new Auth(banque);
        Scanner clavier = new Scanner(System.in);
        Menu.afficherMenuLogin();
        login:
        MenuLogin:
        while (true) {
            System.out.print("Login: ");
            String login = clavier.nextLine();
            System.out.print("Password: ");
            String password = clavier.nextLine();
            User loggedUser = Auth.authenticate(login, password);
            if ( loggedUser!= null) {
                if (loggedUser instanceof Client) {
                    System.out.println("Bienvenue dans le Service Transactionnel des Clients");
                    Thread.sleep(1000);
                    Menu.afficherMenuTransactionelle(loggedUser);
                    menuTransactionelle:
                    while (true) {
                        Menu.choix = clavier.nextInt();
                        while (Menu.choix != 0) {
                            switch (Menu.choix) {
                                case 1:
                                    System.out.println("Vous avez choisi de verser de l'argent");
                                    Thread.sleep(1000);
                                    /*System.out.println("Veuillez saisir l'Id de votre compte: ");
                                    int id = clavier.nextInt();*/
                                    ((Client) loggedUser).afficherCompteClient(loggedUser,banque);
                                    System.out.println("Veuillez saisir le montant à verser: ");
                                    double montant = clavier.nextDouble();
                                    //sb.verser(montant, b.getCompteById(id));
                                    if (sb.verser(montant, banque.getCompteById(((Client) loggedUser).getIdClient()))) {
                                        System.out.println("Le versement a été effectué avec succès!");
                                    } else {
                                        System.err.println("Le versement n'a pas été effectué!");
                                    }
                                    Thread.sleep(1000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    continue menuTransactionelle;


                                case 2:
                                    System.out.println("Vous avez choisi de retirer de l'argent");
                                    System.out.println("Veuillez saisir l'Id du compte: ");
                                    //id = clavier.nextInt();
                                    System.out.println("Veuillez saisir le montant à retirer: ");
                                    montant = clavier.nextDouble();
                                    //sb.retirer(montant, b.getCompteById(id));
                                    if (sb.retirer(montant, banque.getCompteById(((Client) loggedUser).getIdClient()))) {
                                        System.out.println("Le retrait a été effectué avec succès!");
                                    } else {
                                        System.err.println("Le retrait n'a pas été effectué!");
                                    }
                                    Thread.sleep(1000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    continue menuTransactionelle;

                                case 3:
                                    System.out.println("Vous avez choisi de faire un virement");
                                    System.out.println("Veuillez saisir l'Id du compte source: ");
                                    int idsource = clavier.nextInt();
                                    System.out.println("Veuillez saisir l'Id du compte destination: ");
                                    int idDest = clavier.nextInt();
                                    System.out.println("Veuillez saisir le montant à virer: ");
                                    montant = clavier.nextDouble();
                                    //sb.virement(montant, b.getCompteById(idsource),b.getCompteById(idDest));
                                    if (sb.virement(montant, banque.getCompteById(idsource), banque.getCompteById(idDest))) {
                                        System.out.println("Le virement a été effectué avec succès!");
                                    } else {
                                        System.err.println("Le virement n'a pas été effectué!");
                                    }
                                    Thread.sleep(1000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    continue menuTransactionelle;

                                case 4:
                                    System.out.println("Vous avez choisi d'afficher les comptes");
                                    banque.afficherComptesClient(((Client) Auth.authenticate(login, password)).getIdClient());
                                    Thread.sleep(3000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    continue menuTransactionelle;
                                case 5:
                                    System.out.println("Vous avez choisi d'afficher vos informations: ");
                                    System.out.println(loggedUser);
                                    Thread.sleep(3000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    continue menuTransactionelle;


                                case 0:
                                    System.out.println("Vous avez choisi de quitter");
                                    System.out.println("Au revoir!");
                                    Thread.sleep(1000);
                                    break;
                                default:
                                    System.out.println("Veuillez saisir un choix valide!");
                                    Thread.sleep(1000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    break;
                            }
                        }
                    }

                }
                else if ( loggedUser instanceof Admin) {
                    Menu.afficherMenuGeneral(loggedUser);
                    MenuGeneral:
                    while (true) {
                        Menu.choix = clavier.nextInt();
                        while (Menu.choix != 0) {
                            switch (Menu.choix) {
                                case 1:
                                    System.out.println("Vous avez choisi le Service Transactionnel");
                                    Thread.sleep(1000);
                                    Menu.afficherMenuTransactionelle(loggedUser);
                                    menuTransactionelle:
                                    while (true) {
                                        Menu.choix = clavier.nextInt();
                                        while (Menu.choix != 0) {
                                            switch (Menu.choix) {
                                                case 1:
                                                    System.out.println("Vous avez choisi de verser de l'argent");
                                                    Thread.sleep(1000);
                                                    System.out.println("Veuillez saisir l'Id du compte: ");
                                                    int id = clavier.nextInt();
                                                    System.out.println("Veuillez saisir le montant à verser: ");
                                                    double montant = clavier.nextDouble();
                                                    //sb.verser(montant, b.getCompteById(id));
                                                    if (sb.verser(montant, banque.getCompteById(id))) {
                                                        System.out.println("Le versement a été effectué avec succès!");
                                                    } else {
                                                        System.err.println("Le versement n'a pas été effectué!");
                                                    }
                                                    Thread.sleep(1000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    continue menuTransactionelle;


                                                case 2:
                                                    System.out.println("Vous avez choisi de retirer de l'argent");
                                                    System.out.println("Veuillez saisir l'Id du compte: ");
                                                    id = clavier.nextInt();
                                                    System.out.println("Veuillez saisir le montant à retirer: ");
                                                    montant = clavier.nextDouble();
                                                    //sb.retirer(montant, b.getCompteById(id));
                                                    if (sb.retirer(montant, banque.getCompteById(id))) {
                                                        System.out.println("Le retrait a été effectué avec succès!");
                                                    } else {
                                                        System.err.println("Le retrait n'a pas été effectué!");
                                                    }
                                                    Thread.sleep(1000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    continue menuTransactionelle;

                                                case 3:
                                                    System.out.println("Vous avez choisi de faire un virement");
                                                    System.out.println("Veuillez saisir l'Id du compte source: ");
                                                    int idsource = clavier.nextInt();
                                                    System.out.println("Veuillez saisir l'Id du compte destination: ");
                                                    int idDest = clavier.nextInt();
                                                    System.out.println("Veuillez saisir le montant à virer: ");
                                                    montant = clavier.nextDouble();
                                                    //sb.virement(montant, b.getCompteById(idsource),b.getCompteById(idDest));
                                                    if (sb.virement(montant, banque.getCompteById(idsource), banque.getCompteById(idDest))) {
                                                        System.out.println("Le virement a été effectué avec succès!");
                                                    } else {
                                                        System.err.println("Le virement n'a pas été effectué!");
                                                    }
                                                    Thread.sleep(1000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    continue menuTransactionelle;

                                                case 4:
                                                    System.out.println("Vous avez choisi d'afficher les clients");
                                                    sb.afficherClients();
                                                    Thread.sleep(2000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    continue menuTransactionelle;
                                                case 5:
                                                    System.out.println("Vous avez choisi d'afficher les comptes");
                                                    banque.afficherComptes();
                                                    Thread.sleep(2000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    continue menuTransactionelle;

                                                case 6:
                                                    System.out.println("Vous avez choisi de revenir au menu general");
                                                    Thread.sleep(1000);
                                                    Menu.afficherMenuGeneral(loggedUser);
                                                    continue MenuGeneral;

                                                case 0:
                                                    System.out.println("Vous avez choisi de quitter");
                                                    System.out.println("Au revoir!");
                                                    Thread.sleep(1000);
                                                    break;
                                                default:
                                                    System.out.println("Veuillez saisir un choix valide!");
                                                    Thread.sleep(1000);
                                                    Menu.afficherMenuTransactionelle(loggedUser);
                                                    break;
                                            }
                                        }
                                    }

                                case 2:
                                    System.out.println("Vous avez choisi le Service de Gestion");
                                    Thread.sleep(1000);
                                    Menu.afficherMenuServiceGestion();
                                    menuServiceGestion:
                                    while (true) {
                                        Menu.choix = clavier.nextInt();
                                        switch (Menu.choix) {
                                            case 1:
                                                System.out.println("Vous avez choisi d'ajouter un client");
                                                if (sb.creeEtAjouterClient()) {
                                                    System.out.println("Le client a été ajouté avec succès!");
                                                } else {
                                                    System.err.println("Le client n'a pas été ajouté!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 2:
                                                System.out.println("Vous avez choisi de supprimer un client");
                                                if (sb.supprimerClient(clavier)) {
                                                    System.out.println("Le client a été supprimé avec succès!");
                                                } else {
                                                    System.err.println("Le client n'a pas été supprimé!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 3:
                                                System.out.println("Vous avez choisi de modifier un client");
                                                if (sb.modifierClient(clavier)) {
                                                    System.out.println("Le client a été modifié avec succès!");
                                                } else {
                                                    System.err.println("Le client n'a pas été modifié!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 4:
                                                System.out.println("Vous avez choisi d'afficher les clients");
                                                sb.afficherClients();
                                                Thread.sleep(2000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 5:
                                                System.out.println("Vous avez choisi d'ajouter un compte");
                                                if (sb.creeEtAjouterCompte()) {
                                                    System.out.println("Le compte a été ajouté avec succès!");
                                                } else {
                                                    System.out.println("Le compte n'a pas été ajouté!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 6:
                                                System.out.println("Vous avez choisi de supprimer un compte");
                                                if (sb.supprimerCompte(clavier)) {
                                                    System.out.println("Le compte a été supprimé avec succès!");
                                                } else {
                                                    System.out.println("Le compte n'a pas été supprimé!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 7:
                                                System.out.println("Vous avez choisi de modifier un compte");
                                                if (sb.modifierCompte(clavier)) {
                                                    System.out.println("Le compte a été modifié avec succès!");
                                                } else {
                                                    System.out.println("Le compte n'a pas été modifié!");
                                                }
                                                Thread.sleep(1000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 8:
                                                System.out.println("Vous avez choisi d'afficher les comptes");
                                                sb.afficherComptes();
                                                Thread.sleep(2000);
                                                Menu.afficherMenuServiceGestion();
                                                continue menuServiceGestion;
                                            case 9:
                                                System.out.println("Vous avez choisi de revenir au menu general");
                                                Thread.sleep(1000);
                                                Menu.afficherMenuGeneral(loggedUser);
                                                continue MenuGeneral;

                                            case 0:
                                                System.out.println("Vous avez choisi de quitter");
                                                Thread.sleep(1000);
                                                System.out.println("Au revoir!");
                                                break;
                                            default:
                                                System.err.println("Veuillez saisir un choix valide!");
                                                Menu.afficherMenuTransactionelle(loggedUser);
                                                Menu.choix = clavier.nextInt();
                                                break;
                                        }

                                    }
                                case 3:
                                    System.out.println("Vous avez choisi le Service++");
                                    Thread.sleep(1000);
                                    Menu.afficherMenuServicePlus();
                                    menuServicePlus:
                                    while (true) {
                                        Menu.choix = clavier.nextInt();
                                        switch (Menu.choix) {
                                            case 1:
                                                System.out.println("Vous avez choisi de Consulter les informations de la banque");
                                                Thread.sleep(1000);
                                                sb.consulterInformationsBanque();
                                                Thread.sleep(2000);
                                                Menu.afficherMenuServicePlus();
                                                continue menuServicePlus;
                                            case 2:
                                                System.out.println("Vous avez choisi de Lister les Clients de la banque");
                                                Thread.sleep(1000);
                                                sb.listerClientsDeLaBanque();
                                                Thread.sleep(2000);
                                                Menu.afficherMenuServicePlus();
                                                continue menuServicePlus;
                                            case 3:
                                                System.out.println("Vous avez choisi de revenir au menu general");
                                                Thread.sleep(1000);
                                                Menu.afficherMenuGeneral(loggedUser);
                                                continue MenuGeneral;
                                            case 0:
                                                System.out.println("Vous avez choisi de quitter");
                                                Thread.sleep(1000);
                                                System.out.println("Au revoir!");
                                                break;
                                            default:
                                                System.err.println("Veuillez saisir un choix valide!");
                                                Menu.afficherMenuServicePlus();
                                                Menu.choix = clavier.nextInt();
                                                break;
                                        }
                                    }
                                case 4:
                                    if(auth.logout())
                                    {
                                        System.out.println("Deconnection");
                                        Thread.sleep(1000);
                                        Menu.afficherMenuLogin();
                                        clavier.nextLine();
                                        continue MenuLogin;
                                    }
                            }
                        }
                    }
                }
                break MenuLogin;
            } else continue MenuLogin;
        }

        return 1;
    }

}

