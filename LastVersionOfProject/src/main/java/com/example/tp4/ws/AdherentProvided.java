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
import com.example.tp4.service.AdherentService;

@RestController
@RequestMapping("gestion-agence-assurance/Adherent")
public class AdherentProvided {

	@Autowired
	private AdherentService adherentService;

	public List<Adherent> findAll() {
		return adherentService.findAll();
	}

	@GetMapping("/ref/{ref}")
	public Adherent findByRef(@PathVariable String ref) {
		return adherentService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return adherentService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody Adherent adherent) {
		return adherentService.save(adherent);
	}
}