package com.example.tp4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tp4.bean.Adherent;
import com.example.tp4.dao.AdherentDao;

@Service
public class AdherentService {

	@Autowired
	private AdherentDao adherentDao;

	public List<Adherent> findAll() {
		return adherentDao.findAll();
	}

	public int save(Adherent adherent) {
		if (findByRef(adherent.getRef()) != null) {
			return -1;
		}
		adherentDao.save(adherent);
		return 1;
	}

	public Adherent update(Adherent adherent) {
		return adherentDao.save(adherent);
	}

	public Adherent findByRef(String ref) {
		return adherentDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		if (findByRef(ref) == null)
			return -1;
		else
			adherentDao.deleteByRef(ref);
		return 1;
	}

}