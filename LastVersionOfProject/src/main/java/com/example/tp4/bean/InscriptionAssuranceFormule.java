package com.example.tp4.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class InscriptionAssuranceFormule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref;
	private double montant;

	@ManyToOne
	private InscAssu inscAssu;

	@ManyToOne
	private FormuleProduitAssurance formuleProduitAssurance;

	public InscAssu getInscAssu() {
		return inscAssu;
	}

	public void setInscAssu(InscAssu inscAssu) {
		this.inscAssu = inscAssu;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public FormuleProduitAssurance getFormuleProduitAssurance() {
		return formuleProduitAssurance;
	}

	public void setFormuleProduitAssurance(FormuleProduitAssurance formuleProduitAssurance) {
		this.formuleProduitAssurance = formuleProduitAssurance;
	}

}
