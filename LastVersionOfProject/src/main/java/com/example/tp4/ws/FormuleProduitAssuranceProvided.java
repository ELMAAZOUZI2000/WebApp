package com.example.tp4.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.service.FormuleProduitAssuranceService;

@RestController
@RequestMapping("gestion-assurance/formuleproduitassurance")
public class FormuleProduitAssuranceProvided {

	@Autowired
	private FormuleProduitAssuranceService formuleProduitAssuranceService;

	@GetMapping("/")
	public List<FormuleProduitAssurance> findAll() {
		return formuleProduitAssuranceService.findAll();
	}

	@GetMapping("/ref/{ref}")
	public FormuleProduitAssurance findByRef(@PathVariable String ref) {
		return formuleProduitAssuranceService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return formuleProduitAssuranceService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody FormuleProduitAssurance formuleProduitAssurance) {
		return formuleProduitAssuranceService.save(formuleProduitAssurance);
	}

	@PutMapping("/ref/{ref}")
	public int updateFormule(@PathVariable String ref,@RequestBody FormuleProduitAssurance formuleProduitAssurance) {
		return formuleProduitAssuranceService.updateFormule(ref, formuleProduitAssurance);
	}

	@GetMapping("/ref/{ref}/prix/{prix}")
	public List<FormuleProduitAssurance> findByRefLikeAndPrixGreaterThan(@PathVariable String ref,
			@PathVariable double prix) {
		return formuleProduitAssuranceService.findByRefLikeAndPrixGreaterThan(ref, prix);
	}
 
	@GetMapping("/formules/refProduit/{refProduit}")
	public List<FormuleProduitAssurance> findByProduitAssuranceRef(@PathVariable("refProduit") String ref) {
		return formuleProduitAssuranceService.findByProduitAssuranceRef(ref);
	}

	@GetMapping("/id/{id}")
	public FormuleProduitAssurance getOne(Long id) {
		return formuleProduitAssuranceService.getOne(id);
	}

	
}
