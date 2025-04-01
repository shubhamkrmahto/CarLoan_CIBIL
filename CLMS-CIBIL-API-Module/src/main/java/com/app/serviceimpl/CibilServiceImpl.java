package com.app.serviceimpl;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.CibilEntity;
import com.app.enums.CibilStatusEnum;
import com.app.repo.CibilRepository;
import com.app.service.CibilServiceI;
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
			entity.setCibilScoreDateTime(LocalDateTime.now());
			entity.setStatus(cibil.getStatus());
			entity.setCibilRemark(cibil.getCibilRemark());
			
			cibilRepo.save(entity);
			  
			return "Data Updated Successfully";
		}
		return "Record not found";	
	}
	public CibilEntity save(CibilEntity ce) {
		
		// TODO Auto-generated method stub
		
		
			ce.setStatus(CibilStatusEnum.PENDING);
			ce.setCibilScoreDateTime(LocalDateTime.now());
			return cibilRepo.save(ce);
	}


}
