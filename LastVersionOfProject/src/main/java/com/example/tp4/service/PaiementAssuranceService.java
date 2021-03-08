package com.example.tp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.bean.InscAssu;
import com.example.tp4.bean.PaiementAssurance;
import com.example.tp4.dao.PaiementAssuranceDao;

@Service
public class PaiementAssuranceService {

	@Autowired
	private PaiementAssuranceDao paiementAssuranceDao;

	@Autowired
	private InscAssuService inscAssuService;

	public PaiementAssurance findByRef(String ref) {
		return paiementAssuranceDao.findByRef(ref);
	}

	public PaiementAssurance deleteByRef(String ref) {
		return paiementAssuranceDao.deleteByRef(ref);
	}

	public List<PaiementAssurance> findByInscAssuRef(String ref) {
		return paiementAssuranceDao.findByInscAssuRef(ref);
	}

	public int deleteByInscAssuRef(String ref) { 
		return paiementAssuranceDao.deleteByInscAssuRef(ref);
	}

	public int save(PaiementAssurance paiementAssurance) {

		if (findByRef(paiementAssurance.getRef()) != null) {
			return -1;
		}

		InscAssu inscAssu = inscAssuService.findByRef(paiementAssurance.getInscAssu().getRef());
		paiementAssurance.setInscAssu(inscAssu);
		
		if (inscAssu == null) {
			return -2;
		} else {
			double nouveauMontant = inscAssu.getMontantPaye() + paiementAssurance.getMontant();
			if (inscAssu.getMontantPremierPrime() < nouveauMontant) {
				return -3;
			} else { 
				inscAssu.setMontantPaye(nouveauMontant);
				inscAssuService.update(inscAssu);
				paiementAssuranceDao.save(paiementAssurance);
				return 1;
			}

		}

	}

	public int payeInscriptionAssurance(String refInsc, double MontantPaye) {
		InscAssu inscAssu = inscAssuService.findByRef(refInsc);

		if (inscAssu == null) {
			return -1;
		}

		double nouveauMontantPaye = inscAssu.getMontantPaye() + MontantPaye;

		if (nouveauMontantPaye > inscAssu.getMontantPremierPrime()) {
			return -2;
		} else {
			inscAssu.setMontantPaye(nouveauMontantPaye);
			inscAssuService.save(inscAssu);
			return 1;
		}
	}

	public List<PaiementAssurance> findAll() {
		return paiementAssuranceDao.findAll();
	}

}
