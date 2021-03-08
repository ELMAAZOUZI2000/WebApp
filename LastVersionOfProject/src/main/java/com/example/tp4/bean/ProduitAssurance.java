package com.example.tp4.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProduitAssurance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ref;
	private String descripttion;
	private String dateValiditeMin;
	private String dateValidateMax;


	public ProduitAssurance() {
		super();
	}
	
	public ProduitAssurance(Long id, String descripttion, String dateValiditeMin, String dateValidateMax) {
		super();
		this.id = id;
		this.descripttion = descripttion;
		this.dateValiditeMin = dateValiditeMin;
		this.dateValidateMax = dateValidateMax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripttion() {
		return descripttion;
	}

	public void setDescripttion(String descripttion) {
		this.descripttion = descripttion;
	}

	public String getDateValiditeMin() {
		return dateValiditeMin;
	}

	public void setDateValiditeMin(String dateValiditeMin) {
		this.dateValiditeMin = dateValiditeMin;
	}

	public String getDateValidateMax() {
		return dateValidateMax;
	}

	public void setDateValidateMax(String dateValidateMax) {
		this.dateValidateMax = dateValidateMax;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}
