package com.service.vaccinationcenterservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.service.vaccinationcenterservice.entity.VaccinationCenter;
import com.service.vaccinationcenterservice.exception.VaccinationCenterNotExistsException;
import com.service.vaccinationcenterservice.repository.VaccinationRepository;
@Service
public class VaccinationCenterService {
	@Autowired
	VaccinationRepository vr;

	public VaccinationCenter save(VaccinationCenter vaccinationCenter) {
		// TODO Auto-generated method stub
		return vr.save(vaccinationCenter);
	}

	public VaccinationCenter findById(Integer id) {
		// TODO Auto-generated method stub
		return vr.findById(id).get();
	}

	public VaccinationCenter getVcDetails(String name) throws VaccinationCenterNotExistsException {
		// TODO Auto-generated method stub
		VaccinationCenter vcr=vr.findByCenterName(name);
		if(vcr==null) {
			throw new VaccinationCenterNotExistsException("Vaccination center not exists");
		} else {
			return vcr;
		}
		
	}

	
}
