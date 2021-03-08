package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.InscriptionAssuranceFormule;

@Repository
public interface InscriptionAssuranceFormuleDao extends JpaRepository<InscriptionAssuranceFormule, Long> {

	InscriptionAssuranceFormule findByRef(String ref);

	int deleteByRef(String ref);

	int deleteByInscAssuRef(String refInscAssu);

	List<InscriptionAssuranceFormule> findByInscAssuRef(String refInscAssu);
	
	List<InscriptionAssuranceFormule> findByFormuleProduitAssuranceRef(String ref);

	List<InscriptionAssuranceFormule> findByFormuleProduitAssuranceProduitAssuranceRef(String ref);


}
