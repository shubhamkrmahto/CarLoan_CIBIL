package com.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CibilEntity;
import com.app.repo.CibilRepository;
import com.app.service.CibilServiceI;
@Service
public class CibilServiceImpl implements CibilServiceI {
	@Autowired
	CibilRepository cibilRepo;

	@Override
	public Iterable<CibilEntity> findAll() {
		
		
		return cibilRepo.findAll();
	}

	@Override
	public CibilEntity getSingleData(Integer id) {
		Optional<CibilEntity> cibilById = cibilRepo.findById(id);
		
		return cibilById.get();
	}

	
}
