package com.service.vaccinationcenterservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.vaccinationcenterservice.entity.VaccinationCenter;

public interface VaccinationRepository extends JpaRepository<VaccinationCenter, Integer>{
	public VaccinationCenter findByCenterName(String name);

}
