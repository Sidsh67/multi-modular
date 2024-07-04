package com.module.patient.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.module.doctor.Doctor;

@FeignClient(name = "DOCTORCLIENT",url = "localhost:8080",path = "doctors")
public interface DoctorServiceConfig {
	
	@PostMapping
	public Doctor save(Doctor dr);
	
	@GetMapping("/patient/{id}")
	public List<Doctor> getByPatientId(@PathVariable("id") int id);
	
	@PutMapping("/{id}")
	public Doctor updateDetail(@RequestBody Doctor doctor, @PathVariable Integer id);
	
	}
