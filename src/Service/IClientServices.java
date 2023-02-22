package Service;

import Model.Client;

public interface IClientServices {
    public int getIdClient();
    public void setIdClient(int idClient);
    public String getNom();
    public void setNom(String nom);
    public String getPrenom();
    public void setPrenom(String prenom);
    public String getEmail();
    public void setEmail(String email);
    public String toString();
    public boolean equals(Client autreClient);
}

