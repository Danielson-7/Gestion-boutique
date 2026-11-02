/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Client;

/**
 *
 * @author danielson
 */
public class ClientService {

    private static ClientService instance;
    private List<Client> listeClient;

    private ClientService() {
        listeClient = new ArrayList<>();
    }

    public static synchronized ClientService getInstance() {
        if (instance == null) {
            instance = new ClientService();
        }
        return instance;
    }

    public void ajouter(Client c) {
        if (c == null) {
            throw new IllegalArgumentException("Le client à ajouter ne peut pas être null.");
        }
        listeClient.add(c);
    }

    public Client trouver(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du client doit être strictement supérieur à 0.");
        }

        for (Client c : listeClient) {
            if (c.getId() == id) {
                return c;
            }
        }
        
        throw new NoSuchElementException("Aucun client trouvé avec l'identifiant : " + id);
    }

    public void modifier(Client c) {
        if (c == null) {
            throw new IllegalArgumentException("Le client à modifier ne peut pas être null.");
        }

        int index = listeClient.indexOf(c);
        if (index != -1) {
            listeClient.set(index, c);
        } else {
            throw new NoSuchElementException("Impossible de modifier : le client avec l'ID " + c.getId() + " n'existe pas.");
        }
    }

    public void supprimer(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du client à supprimer doit être valide.");
        }

        Client c = trouver(id);
        listeClient.remove(c);
    }

    public void supprimer(Client c) {
        if (c == null) {
            throw new IllegalArgumentException("Le client à supprimer ne peut pas être null.");
        }

        if (!listeClient.contains(c)) {
            throw new NoSuchElementException("Impossible de supprimer : ce client n'existe pas dans la liste.");
        }
        listeClient.remove(c);
    }

    public int compter() {
        return listeClient.size();
    }

    public List<Client> lister() {
        return listeClient;
    }
}
