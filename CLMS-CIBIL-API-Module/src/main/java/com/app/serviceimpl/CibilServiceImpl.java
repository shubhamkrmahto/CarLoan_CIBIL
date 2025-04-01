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
<<<<<<< HEAD
		return "Record not found";	
=======
		return "Invalid Id.";	
>>>>>>> branch 'master' of https://github.com/shubhamkrmahto/CarLoan_CIBIL
	}
	
	@Override
	public CibilEntity save(CibilEntity ce) {
			
		
			ce.setStatus(CibilStatusEnum.PENDING);
			ce.setCibilScoreDateTime(LocalDateTime.now());
			return cibilRepo.save(ce);
	}


	@Override
	public CibilEntity updateCibilScore(Integer cibilId, Integer cibilScore) {
		
		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {
			  
			CibilEntity cibilEntity=byId.get();
			cibilEntity.setCibilScore(cibilScore);
		 return 	cibilRepo.save(cibilEntity);
			

		}
		
		return null;
	}

	@Override
	public CibilEntity updateCibilScoreStatus(Integer cibilId, CibilStatusEnum status) {

		
		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {
			  
			CibilEntity cibilEntity=byId.get();
			cibilEntity.setStatus(status);
		 return 	cibilRepo.save(cibilEntity);
			
		}
		
		
		return null;
	}

	@Override
	public CibilEntity updateCibilRemark(Integer cibilId, String cibilRemark) {
		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {
			  
			CibilEntity cibilEntity=byId.get();
			cibilEntity.setCibilRemark(cibilRemark);
		 return 	cibilRepo.save(cibilEntity);
		}
		return null;
	}

	
	@Override
	public void deleteCibilEnquiry(Integer id) {
		// TODO Auto-generated method stub
		
			cibilRepo.deleteById(id);		
		}
	
	

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
