package com.example.tp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.bean.InscAssu;
import com.example.tp4.bean.InscriptionAssuranceFormule;
import com.example.tp4.dao.InscriptionAssuranceFormuleDao;

@Service
public class InscriptionAssuranceFormuleService {

	@Autowired
	private InscriptionAssuranceFormuleDao inscriptionAssuranceFormuleDao;
	 
	@Autowired
	private InscAssuService inscAssuService;
	
	@Autowired
	private FormuleProduitAssuranceService formuleProduitAssuranceService;
	
	public int deleteByInscAssuRef(String refInscAssu) {
		return inscriptionAssuranceFormuleDao.deleteByInscAssuRef(refInscAssu);
	}

	public List<InscriptionAssuranceFormule> findByInscAssuRef(String refInscAssu) {
		return inscriptionAssuranceFormuleDao.findByInscAssuRef(refInscAssu);
	}
  

	public InscriptionAssuranceFormule findByRef(String ref) {
		return inscriptionAssuranceFormuleDao.findByRef(ref);
	}

	public int deleteByRef(String ref) {
		return inscriptionAssuranceFormuleDao.deleteByRef(ref);
	}


	public int save(InscriptionAssuranceFormule inscriptionAssuranceFormule) {
		if (findByRef(inscriptionAssuranceFormule.getRef()) != null) {
			return -1;
		}
		InscAssu inscAssu = inscAssuService
				.findByRef(inscriptionAssuranceFormule.getInscAssu().getRef());
		FormuleProduitAssurance formuleProduitAssurance = formuleProduitAssuranceService.findByRef(inscriptionAssuranceFormule.getFormuleProduitAssurance().getRef());
		
		if (inscAssu == null || formuleProduitAssurance==null) {
			return -2;
		} else{
			inscriptionAssuranceFormule.setFormuleProduitAssurance(formuleProduitAssurance);
			inscriptionAssuranceFormule.setInscAssu(inscAssu);
			inscriptionAssuranceFormuleDao.save(inscriptionAssuranceFormule);
			return 1;
		}

	}
	public List<InscriptionAssuranceFormule> findAll() {
		return inscriptionAssuranceFormuleDao.findAll();
	}

	public InscriptionAssuranceFormule findById(Long id) {
		return inscriptionAssuranceFormuleDao.findById(id).get();
	}

	public List<InscriptionAssuranceFormule> findByFormuleProduitAssuranceRef(String ref) {
		return inscriptionAssuranceFormuleDao.findByFormuleProduitAssuranceRef(ref);
	}

	public List<InscriptionAssuranceFormule> findByFormuleProduitAssuranceProduitAssuranceRef(String ref) {
		return inscriptionAssuranceFormuleDao.findByFormuleProduitAssuranceProduitAssuranceRef(ref);
	}
	
	
	
}
