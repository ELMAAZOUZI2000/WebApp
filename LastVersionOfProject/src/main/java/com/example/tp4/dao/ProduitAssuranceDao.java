package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.Adherent;
import com.example.tp4.bean.ProduitAssurance;

@Repository
public interface ProduitAssuranceDao extends JpaRepository<ProduitAssurance, Long> {

	ProduitAssurance findByRef(String ref);

	int deleteByRef(String ref);
}











/*@Query("FROM Adherent a,ProduitAssurance p,InscAssu i,InscriptionAssuranceFormule if,FormuleProduitAssurance fp WHERE "
		+ "a.id=i.adherent AND i.id=if.inscAssu AND if.formuleProduitAssurance= fp.id AND fp.produitAssurance=p.id AND p.ref=:refProduit")
List<Adherent> findAdherent(@Param("refProduit") String refProduit);*/