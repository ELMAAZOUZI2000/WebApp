package com.example.tp4.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.bean.Adherent;
import com.example.tp4.bean.InscriptionAssuranceFormule;
import com.example.tp4.bean.ProduitAssurance;
import com.example.tp4.dao.ProduitAssuranceDao;

@Service
public class ProduitAssuranceService {

	@Autowired
	private ProduitAssuranceDao produitAssuranceDao;

	@Autowired
	private FormuleProduitAssuranceService formuleProduitAssuranceService;

	@Autowired
	private InscriptionAssuranceFormuleService inscriptionAssuranceFormuleService;

	public ProduitAssuranceService() {
		super();
	}

	public ProduitAssurance findByRef(String ref) {
		return produitAssuranceDao.findByRef(ref);
	}

	public int save(ProduitAssurance produitAssurance) {
		if (findByRef(produitAssurance.getRef()) != null) {
			return -1;
		} else {
			produitAssuranceDao.save(produitAssurance);
			return 1;
		}

	}

	public int update(String ref, ProduitAssurance produitAssurance) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			produitAssuranceDao.save(produitAssurance);
			return 1;
		}
	}

	public int deleteByRef(String ref) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			formuleProduitAssuranceService.deleteByProduitAssuranceRef(ref);
			produitAssuranceDao.deleteByRef(ref);
			return 1;
		}

	}

	public List<Adherent> findAdherents(String refProduit) {

		List<InscriptionAssuranceFormule> allFormules = inscriptionAssuranceFormuleService
				.findByFormuleProduitAssuranceProduitAssuranceRef(refProduit);

		List<Adherent> getAll = new ArrayList<>();
		for (int i = 0; i < allFormules.size(); i++) {

			Adherent adherent = allFormules.get(i).getInscAssu().getAdherent();
			getAll.add(adherent);
		}

		return getAll;
	}

	public List<ProduitAssurance> findAll() {
		return produitAssuranceDao.findAll();
	}


	
	/*
	public List<Adherent> findAdherent(String refProduit) {
		return produitAssuranceDao.findAdherent(refProduit);
	}
*/
}
