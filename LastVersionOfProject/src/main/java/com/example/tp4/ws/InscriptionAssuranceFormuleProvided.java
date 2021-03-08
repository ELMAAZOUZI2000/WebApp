package com.example.tp4.ws;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.bean.InscriptionAssuranceFormule;
import com.example.tp4.service.InscriptionAssuranceFormuleService;

@RestController
@RequestMapping("gestion-assurance/inscriptionassuranceformule")
public class InscriptionAssuranceFormuleProvided {
	
	@Autowired
	private InscriptionAssuranceFormuleService inscriptionAssuranceService;

	@DeleteMapping("/inscription/ref/{ref}")
	public int deleteByInscAssuRef(@PathVariable String refInscAssu) {
		return inscriptionAssuranceService.deleteByInscAssuRef(refInscAssu);
	}
	
	@GetMapping("/inscription/ref/{ref}")
	public List<InscriptionAssuranceFormule> findByInscAssuRef(@PathVariable String refInscAssu) {
		return inscriptionAssuranceService.findByInscAssuRef(refInscAssu);
	}
  
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return inscriptionAssuranceService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody InscriptionAssuranceFormule inscriptionAssuranceFormule) {
		return inscriptionAssuranceService.save(inscriptionAssuranceFormule);
	}

	@GetMapping("/id/{id}")
	public  InscriptionAssuranceFormule findById(@PathVariable Long id) {
		return inscriptionAssuranceService.findById(id);
	}

	@GetMapping("/")
	public List<InscriptionAssuranceFormule> findAll() {
		return inscriptionAssuranceService.findAll();
	}  
}
