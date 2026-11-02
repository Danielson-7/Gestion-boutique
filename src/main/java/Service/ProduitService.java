/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Produit;

/**
 *
 * @author danielson
 */
public class ProduitService {

    private static ProduitService instance;
    private List<Produit> listeProduit;

    private ProduitService() {
        listeProduit = new ArrayList<>();
    }

    public static synchronized ProduitService getInstance() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    public void ajouter(Produit p) {

        if (p == null) {
            throw new IllegalArgumentException("Le produit à ajouter ne peut pas être null.");
        }
        this.listeProduit.add(p);
    }

    public Produit trouver(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du produit doit être strictement supérieur à 0.");
        }

        for (Produit p : listeProduit) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new NoSuchElementException("Aucun produit trouvé avec l'identifiant : " + id);
    }

    public void modifier(Produit p) {
        if (p == null) {
            throw new IllegalArgumentException("Le produit à modifier ne peut pas être null.");
        }

        int index = listeProduit.indexOf(p);
        if (index != -1) {
            listeProduit.set(index, p);
        } else {
            throw new NoSuchElementException("Impossible de modifier : le produit avec l'ID " + p.getId() + " n'existe pas.");
        }
    }

    public void supprimer(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant du produit à supprimer doit être valide.");
        }

        Produit p = trouver(id);
        this.listeProduit.remove(p);
    }

    public void supprimer(Produit p) {
        if (p == null) {
            throw new IllegalArgumentException("Le produit à supprimer ne peut pas être null.");
        }

        if (!listeProduit.contains(p)) {
            throw new NoSuchElementException("Impossible de supprimer : ce produit n'existe pas dans la liste.");
        }
        listeProduit.remove(p);
    }

    public int compter() {
        return listeProduit.size();
    }

    public List<Produit> lister() {
        return this.listeProduit;
    }

    public List<Produit> listerPerimes() {
        List<Produit> perimes = new ArrayList<>();
        for (Produit p : listeProduit) {
            if (p.estPerime()) {
                perimes.add(p);
            }
        }
        return perimes;
    }

}
