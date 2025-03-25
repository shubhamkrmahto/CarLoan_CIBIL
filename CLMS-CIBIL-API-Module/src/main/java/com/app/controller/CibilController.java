package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CibilEntity;
import com.app.enums.CibilStatusEnum;
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

	
	@DeleteMapping("/deleteCibilEnquiry/{id}")
	 public ResponseEntity<String> deleteCibilData(@PathVariable ("id") Integer id)
	 {
			service.deleteCibilEnquiry(id);
			return new ResponseEntity<String>("Delete Your cibil Field Successfully...!",HttpStatus.OK);

	 }

	 
	 @PatchMapping("change_CibilStatus/{cibilId}/{status}")
	 public ResponseEntity<CibilEntity> onChangeCibilStatus(@PathVariable ("cibilId")Integer cibilId,
			                                               @PathVariable ("status")CibilStatusEnum status)
	 
	 {
		 CibilEntity cibilEntity=service.updateCibilScoreStatus(cibilId,status);
		 return new ResponseEntity<CibilEntity>(cibilEntity,HttpStatus.OK);
		 
	
	 }
	 
	 @PatchMapping("change_cibilScore/{cibilId}/{cibilScore}")
	 public ResponseEntity<CibilEntity> onChangeCibilScore(@PathVariable ("cibilId")Integer cibilId,
			                                               @PathVariable ("cibilScore")Integer cibilScore)
	 
	 {
		 CibilEntity cibilEntity=service.updateCibilScore(cibilId,cibilScore);
		 return new ResponseEntity<CibilEntity>(cibilEntity,HttpStatus.OK);	
	 }
	 
	 @PatchMapping("change_cibilScore_remark/{cibilId}/{cibilRemark}")
	 public ResponseEntity<CibilEntity> onChangeCibilcibilRemark(@PathVariable ("cibilId")Integer cibilId,
			                                               @PathVariable ("cibilRemark")String cibilRemark)
	 
	 {
		 CibilEntity cibilEntity=service.updateCibilRemark(cibilId,cibilRemark);
		 return new ResponseEntity<CibilEntity>(cibilEntity,HttpStatus.OK);
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
