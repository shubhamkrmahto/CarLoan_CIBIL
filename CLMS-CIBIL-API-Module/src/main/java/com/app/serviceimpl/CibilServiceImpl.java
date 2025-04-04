package com.app.serviceimpl;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.repo.CibilRepository;
import com.app.service.CibilServiceI;

@Service
public class CibilServiceImpl implements CibilServiceI {

	private final Random random = new Random();
	
	@Autowired
	CibilRepository cibilRepo;


	@Override
	public Integer generateCibil() {
		
		return random.nextInt(550,900);
	}

	

}
