package com.app.serviceimpl;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CibilEntity;
import com.app.enums.CibilStatusEnum;
import com.app.repo.CibilRepository;
import com.app.service.CibilServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	
	public CibilEntity save(String ce) {
		
		// TODO Auto-generated method stub
		
		ObjectMapper om = new ObjectMapper();
		
		CibilEntity cibilDetails;
		try {
			cibilDetails = om.readValue(ce, CibilEntity.class);
			cibilDetails.setStatus(CibilStatusEnum.PENDING);
			cibilDetails.setCibilScoreDateTime(LocalDateTime.now());
			return cibilRepo.save(cibilDetails);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
