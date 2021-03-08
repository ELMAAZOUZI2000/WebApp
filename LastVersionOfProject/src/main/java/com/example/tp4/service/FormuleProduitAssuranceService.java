package com.example.tp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.bean.ProduitAssurance;
import com.example.tp4.dao.FormuleProduitAssuranceDao;

@Service
public class FormuleProduitAssuranceService {

	@Autowired
	private FormuleProduitAssurance formuleProduitAssurance;

	@Autowired
	private FormuleProduitAssuranceDao formuleProduitAssuranceDao;

	@Autowired
	private ProduitAssuranceService produitAssuranceService;

	@Autowired
	private InscriptionAssuranceFormuleService inscriptionAssuranceFormuleService;

	public List<FormuleProduitAssurance> findAll() {
		return formuleProduitAssuranceDao.findAll();
	}

	public FormuleProduitAssurance findByRef(String ref) {
		return formuleProduitAssuranceDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			inscriptionAssuranceFormuleService.deleteByFormuleProduitAssuranceRef(ref);
			formuleProduitAssuranceDao.deleteByRef(ref);
			return 1;
		}
	}

	public int save(FormuleProduitAssurance formuleProduitAssurance) {
		if (findByRef(formuleProduitAssurance.getRef()) != null) {
			return -1;
		}
		ProduitAssurance produitAssurance = produitAssuranceService
				.findByRef(formuleProduitAssurance.getProduitAssurance().getRef());

		if (produitAssurance == null) {
			return -2;
		} else {
			formuleProduitAssurance.setProduitAssurance(produitAssurance);
			formuleProduitAssuranceDao.save(formuleProduitAssurance);
			return 1;
		}

	}

	public int updateFormule(String ref, FormuleProduitAssurance formuleProduitAssurance) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			formuleProduitAssuranceDao.save(formuleProduitAssurance);
			return 1;
		}
	}

	public List<FormuleProduitAssurance> findByProduitAssuranceRef(String refProduit) {
		return formuleProduitAssuranceDao.findByProduitAssuranceRef(refProduit);
	}

	public int deleteByProduitAssuranceRef(String refProduit) {
		return formuleProduitAssuranceDao.deleteByProduitAssuranceRef(refProduit);
	}

	public List<FormuleProduitAssurance> findByRefLikeAndPrixGreaterThan(String ref, double prix) {
		return formuleProduitAssuranceDao.findByRefLikeAndPrixGreaterThan(ref, prix);
	}

	public FormuleProduitAssurance getOne(Long id) {
		return formuleProduitAssuranceDao.getOne(id);
	}

}
