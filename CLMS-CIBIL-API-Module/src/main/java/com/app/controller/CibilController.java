package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.CibilServiceI;

@RestController
@RequestMapping("/cibil")
public class CibilController {

	@Autowired
	CibilServiceI service;
	
	@GetMapping("/generateCibil")
	public ResponseEntity<Integer> generateCibil()
	{
		return new ResponseEntity<Integer>(service.generateCibil(),HttpStatus.OK);
	}
	
	
}
