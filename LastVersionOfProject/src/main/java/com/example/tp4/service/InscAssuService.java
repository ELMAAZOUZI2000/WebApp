package com.example.tp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tp4.bean.Adherent;
import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.bean.InscAssu;
import com.example.tp4.bean.InscriptionAssuranceFormule;
import com.example.tp4.bean.PaiementAssurance;
import com.example.tp4.dao.InscAssuDao;

@Service
public class InscAssuService {

	@Autowired
	private InscAssuDao inscassudao;

	@Autowired
	private InscriptionAssuranceFormuleService inscriptionAssuranceFormuleService;

	@Autowired
	private AdherentService adherentService;

	@Autowired
	private PaiementAssuranceService paiementAssuranceService;
	
	public int save(InscAssu inscAssu) {
		if (findByRef(inscAssu.getRef()) != null) {
			return -1;
		}

		Adherent adherent = adherentService.findByRef(inscAssu.getAdherent().getRef());

		if (adherent == null) {
			return -2;
		} else {
			inscAssu.setAdherent(adherent);
			inscassudao.save(inscAssu);
			return 1;
		}

	}

	@Transactional
	public int deleteByRef(String ref) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			paiementAssuranceService.deleteByInscAssuRef(ref);
			inscriptionAssuranceFormuleService.deleteByInscAssuRef(ref);
			inscassudao.deleteByRef(ref);
			return 1;
		}

	}

	public int calculateMontantPremierPrime(String refInscriptionAssurance) {
		// DETERMINATION DES FORMULES D'INSCRIPTIONS QUI CORRESPONDENT A
		// CETTEINSCRIPTION ASSURANCE
		List<InscriptionAssuranceFormule> allFormules = inscriptionAssuranceFormuleService
				.findByInscAssuRef(refInscriptionAssurance);
		if (allFormules == null) {
			return -1;
		} else {
			double primePrice = 0;
			for (int i = 0; i < allFormules.size(); i++) {
				primePrice += allFormules.get(i).getMontant();
			}

			InscAssu inscAssu = findByRef(refInscriptionAssurance);
			inscAssu.setMontantPremierPrime(primePrice);
			update(inscAssu);
			return 1;
		}

	}

	public List<InscAssu> findAll() {
		return inscassudao.findAll();
	}

	public InscAssu update(InscAssu inscAssu) {
		return inscassudao.save(inscAssu);
	}

	public InscAssu getOne(Long aLong) {
		return inscassudao.getOne(aLong);
	}

	public InscAssu findByRef(String ref) {
		return inscassudao.findByRef(ref);
	}

}