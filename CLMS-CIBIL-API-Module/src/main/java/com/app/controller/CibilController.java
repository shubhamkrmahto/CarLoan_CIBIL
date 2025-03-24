package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CibilEntity;
import com.app.service.CibilServiceI;

@RestController
@RequestMapping("/cibil")
public class CibilController {
	@Autowired
	CibilServiceI service;
	
	@PostMapping("/saveCibil")
	public ResponseEntity<String> saveCibilData(@RequestBody CibilEntity  ce)
	{
		
		CibilEntity cibil = service.save(ce);
		System.out.println(cibil);
		
		return new ResponseEntity<String>("Your Cibil Data has been Registered Successfully.", HttpStatus.CREATED);  
	}
	 @PutMapping("/update-cibil")	
	   public ResponseEntity<String> updateCibilDetails(@RequestBody CibilEntity cibil){
		   String msg = service.updateCibil(cibil);
		   
		   return new ResponseEntity<String>(msg,HttpStatus.OK);
		   
	   }
	
	

	@GetMapping("/getCibilAllData")
	public ResponseEntity<Iterable<CibilEntity>> getAllData()
	{
		Iterable<CibilEntity> allData =service.findAll();
		
		return new ResponseEntity<Iterable<CibilEntity>>(allData,HttpStatus.OK);
	}
	
	@GetMapping("/getCibilSingleData/{cibilId}")
	public ResponseEntity<CibilEntity> getSingleData(@PathVariable("cibilId")Integer id)
	{
		CibilEntity cibil=service.getSingleData(id);
		
		return new ResponseEntity<CibilEntity>(cibil, HttpStatus.OK);
	}

}
