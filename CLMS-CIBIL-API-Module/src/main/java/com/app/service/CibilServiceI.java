package com.app.service;

import com.app.entity.CibilEntity;

public interface CibilServiceI {


	String updateCibil(CibilEntity cibil);

	public CibilEntity save(CibilEntity ce);

	void deleteCibilEnquiry(Integer id);
	
}
