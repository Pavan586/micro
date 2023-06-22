package com.service.vaccinationcenterservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service.vaccinationcenterservice.dto.Citizen;
import com.service.vaccinationcenterservice.dto.RequiredResponse;
import com.service.vaccinationcenterservice.entity.VaccinationCenter;
import com.service.vaccinationcenterservice.exception.VaccinationCenterNotExistsException;
import com.service.vaccinationcenterservice.service.VaccinationCenterService;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationController {
	@Autowired
	private VaccinationCenterService vs;
	@Autowired
	private RestTemplate restTemplate;
	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
		VaccinationCenter vaccinationCenterAdded=vs.save(vaccinationCenter);
		return new ResponseEntity<>(vaccinationCenterAdded,HttpStatus.OK);
		
		
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
		RequiredResponse requiredResponse=new RequiredResponse();
		VaccinationCenter center=vs.findById(id);
		requiredResponse.setCenter(center);
		List<Citizen> listofcitizens=restTemplate.getForObject("http://localhost:8084/citizen/id/"+id, List.class);
		requiredResponse.setCitizens(listofcitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse,HttpStatus.OK);
		
	}
	@GetMapping("/vcd/{id}")
	public ResponseEntity<VaccinationCenter> getVaccinationCenterDetails(@PathVariable Integer id) {
		VaccinationCenter center=vs.findById(id);
		return new ResponseEntity<VaccinationCenter>(center,HttpStatus.OK);
	}
	@GetMapping("/getvc/{name}")
	public ResponseEntity<VaccinationCenter> getVcDetails(@PathVariable String name) throws VaccinationCenterNotExistsException {
			VaccinationCenter vc=vs.getVcDetails(name);
			return new ResponseEntity<>(vc,HttpStatus.OK);
	}
	

}
