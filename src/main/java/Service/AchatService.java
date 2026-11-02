/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Achat;

/**
 *
 * @author danielson
 */
public class AchatService {

    private static AchatService instance;
    private List<Achat> listeAchat;

    private AchatService() {
        listeAchat = new ArrayList<>();
    }

    public static synchronized AchatService getInstance() {
        if (instance == null) {
            instance = new AchatService();
        }
        return instance;
    }

    public void ajouter(Achat a) {
        if (a == null) {
            throw new IllegalArgumentException("L'achat à ajouter ne peut pas être null.");
        }
        this.listeAchat.add(a);
    }

    public Achat trouver(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'achat doit être strictement supérieur à 0.");
        }

        for (Achat a : listeAchat) {
            if (a.getId() == id) {
                return a;
            }
        }

        throw new NoSuchElementException("Aucun achat trouvé avec l'identifiant : " + id);
    }

    public void modifier(Achat a) {
        if (a == null) {
            throw new IllegalArgumentException("L'achat à modifier ne peut pas être null.");
        }

        int index = listeAchat.indexOf(a);
        if (index != -1) {
            listeAchat.set(index, a);
        } else {
            throw new NoSuchElementException("Impossible de modifier : l'achat avec l'ID " + a.getId() + " n'existe pas.");
        }
    }

    public void supprimer(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'achat à supprimer doit être valide.");
        }

        Achat a = trouver(id);
        this.listeAchat.remove(a);
    }

    public void supprimer(Achat a) {
        if (a == null) {
            throw new IllegalArgumentException("L'achat à supprimer ne peut pas être null.");
        }

        if (!listeAchat.contains(a)) {
            throw new NoSuchElementException("Impossible de supprimer : cet achat n'existe pas dans la liste.");
        }
        listeAchat.remove(a);
    }

    public int compter() {
        return listeAchat.size();
    }

    public List<Achat> lister() {
        return this.listeAchat;
    }
}
