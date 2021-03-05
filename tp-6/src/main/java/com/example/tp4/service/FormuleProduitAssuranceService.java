package com.example.tp4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tp4.bean.FormuleProduitAssurance;
import com.example.tp4.dao.FormuleProduitAssuranceDao;

@Service
public class FormuleProduitAssuranceService {

	@Autowired
	private FormuleProduitAssuranceDao formuleProduitAssuranceDao;

	public List<FormuleProduitAssurance> findAll() {
		return formuleProduitAssuranceDao.findAll();
	}

	public FormuleProduitAssurance findByRef(String ref) {
		return formuleProduitAssuranceDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			formuleProduitAssuranceDao.deleteByRef(ref);
			return 1;
		}
	}

	public int save(FormuleProduitAssurance formuleProduitAssurance, Long id) {
		if (findByRef(formuleProduitAssurance.getRef()) != null) {
			return -1;
		} else {
			formuleProduitAssuranceDao.save(formuleProduitAssurance);
			return 1;
		}

	}

	public int update(String ref, FormuleProduitAssurance formuleProduitAssurance) {
		if (findByRef(ref) == null) {
			return -1;
		} else {
			formuleProduitAssuranceDao.save(formuleProduitAssurance);
			return 1;
		}
	}

	public FormuleProduitAssurance findById(Long id) {
		return formuleProduitAssuranceDao.findById(id).get();
	}

	public List<FormuleProduitAssurance> findByReferenceProduitAssurance(String ref) {
		return formuleProduitAssuranceDao.findByReferenceProduitAssurance(ref);
	}

	public List<FormuleProduitAssurance> findByRefLikeAndPrixGreaterThan(String ref, double prix) {
		return formuleProduitAssuranceDao.findByRefLikeAndPrixGreaterThan(ref, prix);
	}

}
