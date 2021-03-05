package com.example.tp4.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FormuleProduitAssurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private String description;
	private double prix;
	private String referenceProduitAssurance;

	public FormuleProduitAssurance() {
		super();
	}

	public FormuleProduitAssurance(Long id, String ref, String refProduitAssurance, String description, double prix,String referenceProduitAssurance) {
		super();
		this.id = id;
		this.ref = ref;
		this.description = description;
		this.referenceProduitAssurance=refProduitAssurance;
		this.prix = prix;
		this.referenceProduitAssurance = referenceProduitAssurance;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getRefProduitAssurance() {
		return referenceProduitAssurance;
	}

	public void setRefProduitAssurance(String refProduitAssurance) {
		this.referenceProduitAssurance = refProduitAssurance;
	}

 

}
