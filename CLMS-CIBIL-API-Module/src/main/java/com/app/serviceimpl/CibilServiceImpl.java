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
