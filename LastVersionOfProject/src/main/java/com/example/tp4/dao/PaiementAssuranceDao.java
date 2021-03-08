package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.PaiementAssurance;

@Repository
public interface PaiementAssuranceDao extends JpaRepository<PaiementAssurance, Long> {

	PaiementAssurance findByRef(String ref);

	PaiementAssurance deleteByRef(String ref);

	List<PaiementAssurance> findByInscAssuRef(String ref);
	
	int deleteByInscAssuRef(String ref);
}
