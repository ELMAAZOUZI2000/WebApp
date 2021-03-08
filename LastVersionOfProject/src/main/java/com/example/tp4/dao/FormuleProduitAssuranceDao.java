package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.FormuleProduitAssurance;

@Repository
public interface FormuleProduitAssuranceDao extends JpaRepository<FormuleProduitAssurance, Long> {

	FormuleProduitAssurance findByRef(String ref);

	int deleteByRef(String ref);

	int deleteByProduitAssuranceRef(String Ref);

	List<FormuleProduitAssurance> findByProduitAssuranceRef(String refProduit);

	List<FormuleProduitAssurance> findByRefLikeAndPrixGreaterThan(String ref, double prix);

}
