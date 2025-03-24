package com.app.service;

import com.app.entity.CibilEntity;

public interface CibilServiceI {

	public Iterable<CibilEntity> findAll();

	public CibilEntity getSingleData(Integer id);

}
