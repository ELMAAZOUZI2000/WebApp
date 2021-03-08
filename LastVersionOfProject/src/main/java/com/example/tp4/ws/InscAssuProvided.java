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

import com.example.tp4.bean.InscAssu;
import com.example.tp4.service.InscAssuService;

@RestController
@RequestMapping("gestion-agence-assurance/InscAssu")
public class InscAssuProvided {
    @PostMapping("/")
    public int save(@RequestBody InscAssu inscAssu) {
        return inscassuservice.save(inscAssu);
    }
    @GetMapping("id/{id}")
    public InscAssu getOne(@PathVariable Long id) {
        return inscassuservice.getOne(id);
    }
    
    @GetMapping("/ref/{ref}")
    public InscAssu findByRef(@PathVariable String ref) {
        return inscassuservice.findByRef(ref);
    }
    @GetMapping("/")
    public List<InscAssu> findAll() {
        return inscassuservice.findAll();
    }
    

    @GetMapping("/total/ref/{ref}")
	public int calculateMontantPremierPrime(@PathVariable("ref") String refInscriptionAssurance) {
		return inscassuservice.calculateMontantPremierPrime(refInscriptionAssurance);
	}



	@Autowired
    private  InscAssuService inscassuservice;
}