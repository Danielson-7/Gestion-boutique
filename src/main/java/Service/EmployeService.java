/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import model.Employe;

/**
 *
 * @author danielson
 */
public class EmployeService {

    private static EmployeService instance;
    private List<Employe> listeEmploye;

    private EmployeService() {
        listeEmploye = new ArrayList<>();
    }

    public static synchronized EmployeService getInstance() {
        if (instance == null) {
            instance = new EmployeService();
        }
        return instance;
    }

    public void ajouter(Employe e) {
        if (e == null) {
            throw new IllegalArgumentException("L'employé à ajouter ne peut pas être null.");
        }
        listeEmploye.add(e);
    }

    public Employe trouver(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'employé doit être strictement supérieur à 0.");
        }

        for (Employe e : listeEmploye) {
            if (e.getId() == id) {
                return e;
            }
        }
        
        throw new NoSuchElementException("Aucun employé trouvé avec l'identifiant : " + id);
    }

    public void modifier(Employe e) {
        if (e == null) {
            throw new IllegalArgumentException("L'employé à modifier ne peut pas être null.");
        }

        int index = listeEmploye.indexOf(e);
        if (index != -1) {
            listeEmploye.set(index, e);
        } else {
            throw new NoSuchElementException("Impossible de modifier : l'employé avec l'ID " + e.getId() + " n'existe pas.");
        }
    }

    public void supprimer(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("L'identifiant de l'employé à supprimer doit être valide.");
        }

        Employe e = trouver(id);
        listeEmploye.remove(e);
    }

    public void supprimer(Employe e) {
        if (e == null) {
            throw new IllegalArgumentException("L'employé à supprimer ne peut pas être null.");
        }

        if (!listeEmploye.contains(e)) {
            throw new NoSuchElementException("Impossible de supprimer : cet employé n'existe pas dans la liste.");
        }
        listeEmploye.remove(e);
    }

    public int compter() {
        return listeEmploye.size();
    }

    public List<Employe> lister() {
        return listeEmploye;
    }
}

