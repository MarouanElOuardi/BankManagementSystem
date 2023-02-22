package Dao;

import Model.Banque;
import Model.Client;
import Model.Compte;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DbFile {

    public static final Path DataBase = Path.of( "DB");
    public static Path clients = DataBase.resolve("clients.csv");
    public static Path comptes = DataBase.resolve("comptes.csv");


    public static void init() throws IOException {
        if (!DbFile.DataBase.toFile().exists()) {
            DataBase.toFile().mkdir();
            //create clients.csv and comptes.csv
            Files.createFile(clients);
            Files.createFile(comptes);
        }
    }

    public static void seed() throws IOException {
        //create headers
        //create clients
        //create comptes
        if (clients.toFile().length() == 0) {
            Files.write(clients, ("idClient,nomClient,prenomClient,emailClient\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(comptes, ("idCompte,idClient,solde\n").getBytes(), StandardOpenOption.APPEND);

            Files.write(clients, ("1,Marouan,ElOuardi,elmarouanelouardi@gmail.com\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(clients, ("2,Cj,Pinky,cj@pinky.com").getBytes(), StandardOpenOption.APPEND);

            Files.write(comptes, ("1,1,1000.0\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(comptes, ("2,2,2000.0\n").getBytes(), StandardOpenOption.APPEND);
            Files.write(comptes, ("3,2,3000.0").getBytes(), StandardOpenOption.APPEND);
        }

    }

    public static void load(Banque banque) throws IOException {
        //read lines in clients.csv
        //create clients

        Files.readAllLines(clients).forEach(line -> {
            if(line.startsWith("idClient") || line.isEmpty())
            {
                return;
            }
            String[] data = line.split(",");
            Client client = new Client(data[1], data[2], data[3]);
            client.setIdClient(Integer.parseInt(data[0]));
            banque.getClients().add(client);
        });

        Files.readAllLines(comptes).forEach(line -> {
            if(line.startsWith("idCompte") || line.isEmpty())
            {
                return;
            }
            String[] data = line.split(",");
            Compte compte = new Compte(Double.parseDouble(data[2]), banque.getClientById(Integer.parseInt(data[1])));
            compte.setIdCompte(Integer.parseInt(data[0]));
            banque.getComptes().add(compte);
        });
    }

    public static void clear() throws IOException {
        Files.write(clients, "".getBytes());
        Files.write(comptes, "".getBytes());
    }

    public static void save(Banque banque) throws IOException {
        clear();

        Files.write(clients, ("idClient,nomClient,prenomClient,emailClient\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(comptes, ("idCompte,idClient,solde\n").getBytes(), StandardOpenOption.APPEND);

        for (Client client : banque.getClients()) {
            Files.write(clients, (client.getIdClient() + "," + client.getNom() + "," + client.getPrenom() + "," + client.getEmail() + "\n").getBytes(), StandardOpenOption.APPEND);
        }

        for (Compte compte : banque.getComptes()) {
            Files.write(comptes, (compte.getIdCompte() + "," + compte.getProproietaire().getIdClient() + "," + compte.getSolde() + "\n").getBytes(), StandardOpenOption.APPEND);
        }
    }
}
