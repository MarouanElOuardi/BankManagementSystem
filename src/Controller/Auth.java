package Controller;
import Model.Admin;
import Model.Banque;
import Model.Client;
import Model.User;

public class Auth {
    private static  Banque banque;

    public Auth(Banque b) {
        this.banque = b;
    }

    public static User authenticate(String login, String password) {
        Admin admin = Admin.getAdmin();
        if (admin.getEmail().equals(login) && admin.getPassword().equals(password)) {
            System.out.println("Connection en tant qu'admin avec succes");
            return admin;
        }
        for(Client client : banque.getClients()) {
            if (client.getEmail().equals(login) && client.getPassword().equals(password)) {
                System.out.println("Connection en tant que client avec succes");
                return client;
            }
        }
        System.err.println("Login ou mot de passe incorrect");
        return null;
    }
    public boolean logout()
    {
        System.out.println("Deconnection avec succes");
        return true;
    }

}
