package com.service.citizenservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.service.citizenservice.dto.VaccinationCenter;
import com.service.citizenservice.entity.Citizen;
import com.service.citizenservice.repository.CitizenRepository;
@Service
public class CitizenService {
	@Autowired
	CitizenRepository cr;
	@Autowired
	private RestTemplate restTemplate;

	public Citizen save(Citizen newCitizen) {
		// TODO Auto-generated method stub
		return cr.save(newCitizen);
	}

	public List<Citizen> findbyVaccinationCenterId(Integer id) {
		// TODO Auto-generated method stub
		return cr.findByVaccinationCenterId(id);
	}

	public VaccinationCenter getVaccinationCenterDetailsByCitizenId(Integer id) {
		// TODO Auto-generated method stub
		Citizen citizen=cr.findById(id).get();
		int vcid=citizen.getVaccinationCenterId();
		VaccinationCenter center=restTemplate.getForObject("http://localhost:8085/vaccinationcenter/vcd/"+vcid,VaccinationCenter.class);
		return center;

		
	}

}
