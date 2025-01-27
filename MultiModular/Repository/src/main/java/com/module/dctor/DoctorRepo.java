package com.module.dctor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.doctor.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

	     List<Doctor> findByPatientId(int patientId);
	
}
