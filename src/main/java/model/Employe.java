/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author danielson
 */
public class Employe extends Personne {

	private LocalDate dateNaissance;

	public Employe() {
		super();
	}

	public Employe( LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String toString() {
		return "Employe{" + "id=" + id + ", nom='" + nom + '\'' + ", prenom='" + prenom + '\'' + ", dateNaissance="
				+ dateNaissance + '}';
	}

}
