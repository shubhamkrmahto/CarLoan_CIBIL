package com.app.service;

import com.app.entity.CibilEntity;
import com.app.enums.CibilStatusEnum;

public interface CibilServiceI {


	String updateCibil(CibilEntity cibil);

	public CibilEntity save(CibilEntity ce);

	public CibilEntity updateCibilScore(Integer cibilId, Integer cibilScore);

	public CibilEntity updateCibilScoreStatus(Integer cibilId, CibilStatusEnum status);

	public CibilEntity updateCibilRemark(Integer cibilId, String cibilRemark);

	void deleteCibilEnquiry(Integer id);
	
	
	public Iterable<CibilEntity> findAll();

	public CibilEntity getSingleData(Integer id);
	
	public Integer generateCibil();
	
}
