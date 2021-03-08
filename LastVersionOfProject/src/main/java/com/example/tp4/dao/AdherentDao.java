package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.Adherent;

@Repository
public interface AdherentDao extends JpaRepository<Adherent,Long> {
	
	List<Adherent> findAll();
    Adherent findByRef(String ref);
    int deleteByRef(String ref);
}