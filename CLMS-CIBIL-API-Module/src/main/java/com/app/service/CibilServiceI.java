package com.app.service;

import com.app.entity.CibilEntity;

public interface CibilServiceI {

	public Iterable<CibilEntity> findAll();

	public CibilEntity getSingleData(Integer id);

	String updateCibil(CibilEntity cibil);

	public CibilEntity save(CibilEntity ce);

	void deleteCibilEnquiry(Integer id);
	
}
