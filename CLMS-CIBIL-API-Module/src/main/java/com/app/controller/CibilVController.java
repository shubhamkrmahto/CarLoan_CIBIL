package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CibilEntity;
import com.app.service.CibilServiceI;

@RestController
public class CibilVController {
	@Autowired
	CibilServiceI service;
	
	
   @PutMapping("/update-cibil")	
   public ResponseEntity<String> updateCibilDetails(@RequestBody CibilEntity cibil){
	   String msg = service.updateCibil(cibil);
	   
	   return new ResponseEntity<String>(msg,HttpStatus.OK);
	   
   }

}
