/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Categorie;

/**
 *
 * @author danielson
 */
public class CategorieService {

    private static CategorieService instance;
    private List<Categorie> listeCategorie;

    private CategorieService() {
        listeCategorie = new ArrayList<>();
    }

    public static synchronized CategorieService getInstance() {
        if (instance == null) {
            instance = new CategorieService();
        }
        return instance;
    }

    public void ajouter(Categorie c) {
        if (c == null) {
            throw new IllegalArgumentException("La catégorie à ajouter ne peut pas être null.");
        }
        listeCategorie.add(c);
    }

    public Categorie trouver(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de la catégorie doit être strictement supérieur à 0.");
        }

        for (Categorie c : listeCategorie) {
            if (c.getId() == id) {
                return c;
            }
        }

        throw new NoSuchElementException("Aucune catégorie trouvée avec l'identifiant : " + id);
    }

    public void modifier(Categorie c) {
        if (c == null) {
            throw new IllegalArgumentException("La catégorie à modifier ne peut pas être null.");
        }

        int index = listeCategorie.indexOf(c);
        if (index != -1) {
            listeCategorie.set(index, c);
        } else {
            throw new NoSuchElementException("Impossible de modifier : la catégorie avec l'ID " + c.getId() + " n'existe pas.");
        }
    }

    public void supprimer(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de la catégorie à supprimer doit être valide.");
        }

        Categorie c = trouver(id);
        listeCategorie.remove(c);
    }

    public void supprimer(Categorie c) {
        if (c == null) {
            throw new IllegalArgumentException("La catégorie à supprimer ne peut pas être null.");
        }

        if (!listeCategorie.contains(c)) {
            throw new NoSuchElementException("Impossible de supprimer : cette catégorie n'existe pas dans la liste.");
        }
        listeCategorie.remove(c);
    }

    public int compter() {
        return listeCategorie.size();
    }

    public List<Categorie> lister() {
        return listeCategorie;
    }
}
