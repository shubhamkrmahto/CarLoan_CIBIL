package com.app.serviceimpl;

import java.util.Random;
import org.springframework.stereotype.Service;
import com.app.service.CibilServiceI;

@Service
public class CibilServiceImpl implements CibilServiceI {

	private final Random random = new Random();

	@Override
	public Integer generateCibil() {
		
		return random.nextInt(550,900);
	}

	

}
