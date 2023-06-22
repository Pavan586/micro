package com.service.vaccinationcenterservice.dto;

import java.util.List;

import com.service.vaccinationcenterservice.entity.VaccinationCenter;

public class RequiredResponse {
	private VaccinationCenter center;
	private List<Citizen> citizens;
	public RequiredResponse(VaccinationCenter center, List<Citizen> citizens) {
		super();
		this.center = center;
		this.citizens = citizens;
	}
	public RequiredResponse() {
		super();
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}
	

}
