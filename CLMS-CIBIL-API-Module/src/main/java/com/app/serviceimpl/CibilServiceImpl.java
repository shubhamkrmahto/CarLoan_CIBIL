package com.app.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger log = LoggerFactory.getLogger(CibilServiceImpl.class);

	
	private final Random random = new Random();
	
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

			log.info("Cibil Data has been updated successfully for Cibil id = " + cibil.getCibilId());

			return "Data Updated Successfully";
		}
		return null;
	}

	@Override
	public CibilEntity save(CibilEntity ce) {

		ce.setStatus(CibilStatusEnum.PENDING);
		ce.setCibilScoreDateTime(LocalDateTime.now());

		log.info("Cibil Data has been saved successfully ");
		return cibilRepo.save(ce);
	}

	@Override
	public CibilEntity updateCibilScore(Integer cibilId, Integer cibilScore) {

		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {

			CibilEntity cibilEntity = byId.get();
			cibilEntity.setCibilScore(cibilScore);
			log.info("Cibil Score has been updated successfully , for this id = " + cibilId);

			return cibilRepo.save(cibilEntity);

		}

		return null;
	}

	@Override
	public CibilEntity updateCibilScoreStatus(Integer cibilId, CibilStatusEnum status) {

		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {

			CibilEntity cibilEntity = byId.get();
			cibilEntity.setStatus(status);
			log.info("Cibil CibilScoreStatus has been updated successfully , for this id = " + cibilId);

			return cibilRepo.save(cibilEntity);

		}

		return null;
	}

	@Override
	public CibilEntity updateCibilRemark(Integer cibilId, String cibilRemark) {
		Optional<CibilEntity> byId = cibilRepo.findById(cibilId);

		if (byId.isPresent()) {

			CibilEntity cibilEntity = byId.get();
			cibilEntity.setCibilRemark(cibilRemark);

			log.info("Cibil CibilRemark has been updated successfully , for this id = " + cibilId);

			return cibilRepo.save(cibilEntity);
		}
		return null;
	}


	
	@Override
	public void deleteCibilEnquiry(Integer id) {
		// TODO Auto-generated method stub
		
			cibilRepo.deleteById(id);
			log.info("Cibil has been Deleted for Cibil id : " + id);
			
		}
	
	

	@Override
	public Iterable<CibilEntity> findAll() {

		log.info(" GET All DATA successfully ");
		return cibilRepo.findAll();
	}

	@Override
	public CibilEntity getSingleData(Integer id) {
		Optional<CibilEntity> cibilById = cibilRepo.findById(id);

		log.info(" GET SINGLE DATA successfully for Cibil id = " + id);

		return cibilById.get();
	}

	@Override
	public Integer generateCibil() {
		
		
		return random.nextInt(300, 900);
	}

	

}
