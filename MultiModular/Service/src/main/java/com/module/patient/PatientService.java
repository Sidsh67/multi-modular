package com.module.patient;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.doctor.Doctor;
import com.module.patient.Patient;
import com.module.patient.PatientRepo;
import com.module.patient.external.services.DoctorServiceConfig;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepo repo;
    

	@Autowired
	private DoctorServiceConfig service;
	
	public Patient save(Patient patient) {
		List<Doctor> doctorList=patient.getDoctor();
		System.out.println("list======="+doctorList);
		Patient pt=repo.save(patient);
		for (Doctor doctors: doctorList) {
			doctors.setPatientId(patient.getPatientId());
			
			Doctor response= service.save(doctors);
			doctors.setId(response.getId());
		}
		
		System.out.println(pt.getPatientId()+"++++++++++");
		
		return pt;
	}
	
	public List<Patient> getAll() {
		
		List<Patient> list = repo.findAll();
		
		for(Patient patients: list){
			
		System.out.println(patients);
		
		List<Doctor> dr = service.getByPatientId(patients.getPatientId());
			
		patients.setDoctor(dr);
		
		}
		
		return list;
	}
	
	public Patient getById(Integer id) {
		Patient pt= repo.findById(id).get();
		
		 List<Doctor> dr=service.getByPatientId(id);
		 pt.setDoctor(dr);
		return pt;
	}
	
	public Patient updateById(Patient patient) {

			List<Doctor> drList= patient.getDoctor();
			
			System.out.println("drList  "+ drList);
			
			for (Doctor doctor : drList) {
				doctor.setPatientId(patient.getPatientId());
				
				
				if(doctor.getId() != 0) {
				 Doctor response =service.updateDetail(doctor, doctor.getId());
				
				 doctor.setId(response.getId());
				
				}
			}

		
		return patient;
	}
	
}
