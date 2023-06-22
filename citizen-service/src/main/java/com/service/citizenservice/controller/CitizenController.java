package com.service.citizenservice.controller;

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

import com.service.citizenservice.dto.VaccinationCenter;
import com.service.citizenservice.entity.Citizen;
import com.service.citizenservice.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	CitizenService cs;
	@Autowired
	private RestTemplate restTemplate;
	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		Citizen citizen=cs.save(newCitizen);
		return new ResponseEntity<Citizen>(citizen,HttpStatus.OK);

	}
	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable Integer id) {
		List<Citizen> listcitizens =cs.findbyVaccinationCenterId(id);
		return new ResponseEntity<>(listcitizens,HttpStatus.OK);

	}
	@GetMapping("/cid/{id}")
	public ResponseEntity<VaccinationCenter> getVaccinationCenterDetailsByCitizenId(@PathVariable Integer id) {
		VaccinationCenter cen=cs.getVaccinationCenterDetailsByCitizenId(id);
		return new ResponseEntity<>(cen,HttpStatus.OK);
		
	}
}
