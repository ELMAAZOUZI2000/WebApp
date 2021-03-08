package com.example.tp4.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp4.bean.Adherent;
import com.example.tp4.bean.ProduitAssurance;
import com.example.tp4.service.ProduitAssuranceService;

@RestController
@RequestMapping("assurance-managment/produitassurance")
public class ProduitAssuranceProvided {

	@Autowired
	private ProduitAssuranceService produitAssuranceService;

	@GetMapping("/ref/{ref}")
	public ProduitAssurance findByRef(@PathVariable String ref) {
		return produitAssuranceService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return produitAssuranceService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody ProduitAssurance produitAssurance) {
		return produitAssuranceService.save(produitAssurance);
	}

	@GetMapping("/")
	public List<ProduitAssurance> findAll() {
		return produitAssuranceService.findAll();
	}

	@GetMapping("/adherents/refProuit/{refProduit}/}")
	public List<Adherent> findAdherents(@PathVariable String refProduit) {
		return produitAssuranceService.findAdherents(refProduit);
	} 
 
	 

}
