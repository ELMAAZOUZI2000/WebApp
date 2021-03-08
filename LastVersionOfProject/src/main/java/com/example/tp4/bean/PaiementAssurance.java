package com.example.tp4.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PaiementAssurance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String ref;
	private double montant;
	private String date;

	@ManyToOne
	private InscAssu inscAssu;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public InscAssu getInscAssu() {
		return inscAssu;
	}

	public void setInscAssu(InscAssu inscAssu) {
		this.inscAssu = inscAssu;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
