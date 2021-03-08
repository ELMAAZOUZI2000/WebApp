package com.example.tp4.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp4.bean.PaiementAssurance;
import com.example.tp4.service.PaiementAssuranceService;

@RestController
@RequestMapping("gestion-agence-assurance/paiementAssurance")
public class PaiementAssuranceProvided {
	
	@Autowired
	private PaiementAssuranceService paiementAssuranceService;

	@GetMapping("/ref/{ref}")
	public PaiementAssurance findByRef(@PathVariable String ref) {
		return paiementAssuranceService.findByRef(ref);
	}

	@Transactional
	@DeleteMapping("/ref/{ref}")
	public PaiementAssurance deleteByRef(@PathVariable String ref) {
		return paiementAssuranceService.deleteByRef(ref);
	}
	
	@GetMapping("/InscriptionAssurance/refInsc/{refInsc}")
	public List<PaiementAssurance> findByInscAssuRef(@PathVariable String refInsc) {
		return paiementAssuranceService.findByInscAssuRef(refInsc);
	}
	
	@Transactional
	@DeleteMapping("/InscriptionAssurance/ref/{ref}")
	public int deleteByInscAssuRef(@PathVariable String ref) {
		return paiementAssuranceService.deleteByInscAssuRef(ref);
	}
	
	@PostMapping("/")
	public int save(@RequestBody PaiementAssurance paiementAssurance) {
		return paiementAssuranceService.save(paiementAssurance);
	}
	
	@PutMapping("/inscrptionAssurance/ref/{ref}/montant/{montant}")
	public int payeInscriptionAssurance(@PathVariable String ref,@PathVariable("montant") double MontantPaye) {
		return paiementAssuranceService.payeInscriptionAssurance(ref, MontantPaye);
	}
	 

	@GetMapping("/")
	public List<PaiementAssurance> findAll() {
		return paiementAssuranceService.findAll();
	}
	
	
}
