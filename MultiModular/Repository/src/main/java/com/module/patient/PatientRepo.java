package com.module.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.doctor.Doctor;
import com.module.patient.Patient;

public interface PatientRepo extends JpaRepository<Patient, Integer>{
	

}
