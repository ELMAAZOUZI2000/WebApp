package com.example.tp4.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.bean.InscAssu;

@Repository
public interface InscAssuDao extends JpaRepository<InscAssu, Long> {

	InscAssu findByRef(String ref);

	InscAssu deleteByRef(String ref);

	List<InscAssu> findAllByRef(String ref);

	InscAssu findByAdherentRef(String ref);

	InscAssu deleteByAdherentRef(String ref);
	 

}