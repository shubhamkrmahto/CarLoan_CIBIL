package com.app.serviceimpl;
import java.time.LocalDateTime;
import java.util.Optional;

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
	public String updateCibil(CibilEntity cibil) {
		
		Optional<CibilEntity> byId = cibilRepo.findById(cibil.getCibilId());
		
		if (byId.isPresent()) {
			CibilEntity entity = byId.get();
			entity.setCibilScore(cibil.getCibilScore());
			entity.setCibilScoreDateTime(cibil.getCibilScoreDateTime());
			entity.setStatus(cibil.getStatus());
			entity.setCibilRemark(cibil.getCibilRemark());
			
			cibilRepo.save(entity);
			
			return "Data Updated Successfully";
		}
		return null;	
	}
	public CibilEntity save(CibilEntity ce) {
		
		// TODO Auto-generated method stub
		
		
			ce.setStatus(CibilStatusEnum.PENDING);
			ce.setCibilScoreDateTime(LocalDateTime.now());
			return cibilRepo.save(ce);
	}
	@Override
	public void deleteCibilEnquiry(Integer id) {
		// TODO Auto-generated method stub
		
			cibilRepo.deleteById(id);		
		}
		
		
	}



