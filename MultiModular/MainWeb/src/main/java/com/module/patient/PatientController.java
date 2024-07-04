package com.module.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private PatientService service;
	@PostMapping
	public Patient save(@RequestBody Patient patient) {
		
		return service.save(patient);
	}
	@GetMapping
	public List<Patient> getAll() {
		
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Patient getById(@PathVariable Integer id) {
		
		return service.getById(id);
	}
	
	@PutMapping("/{id}")
	public Patient update(@RequestBody Patient patient, @PathVariable Integer id) {
		patient.setPatientId(id);
		
		return service.updateById(patient);
	}
	
}
