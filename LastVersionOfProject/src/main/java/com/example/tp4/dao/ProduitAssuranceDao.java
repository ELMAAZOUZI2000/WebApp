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




