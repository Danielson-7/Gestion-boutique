/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author danielson
 */
public class Achat {

    private long id;
    private LocalDate dateAchat;
    private double remise;
    private Employe employe;
    private Client client;
    private List<ProduitAchete> produitsAchetes = new ArrayList<>();

    public Achat() {
    }

    public double getRemiseTotale() {
        double totalRemise = this.remise;
        if (produitsAchetes != null) {
            for (ProduitAchete pa : produitsAchetes) {
                totalRemise += pa.getRemise();
            }
        }
        return totalRemise;
    }

    public double getTotalPayer() {
        double total = 0.0;
        if (produitsAchetes != null) {
            for (ProduitAchete pa : produitsAchetes) {
                total += pa.getProduit().getPrixUnitaire();
            }
        }
        return total - this.getRemiseTotale();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDate dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProduitAchete> getProduitsAchetes() {
        return produitsAchetes;
    }

    public void setProduitsAchetes(List<ProduitAchete> produitsAchetes) {
        this.produitsAchetes = produitsAchetes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Achat achat = (Achat) obj;
        return this.id == achat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Achat{" + "id=" + id + ", dateAchat=" + dateAchat + ", remise=" + remise + ", employe=" + employe
                + ", client=" + client + ", produitsAchetes=" + produitsAchetes + '}';
    }

}
