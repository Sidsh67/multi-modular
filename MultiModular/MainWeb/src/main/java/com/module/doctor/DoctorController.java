package com.module.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.doctor.Doctor;
import com.module.doctor.DoctorService;
import com.module.patient.Patient;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService service;
	
	@PostMapping
	public Doctor save(@RequestBody Doctor dr) {
		Doctor doctor= service.save(dr);
		return doctor;
	}
	@GetMapping
	public List<Doctor> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Doctor getById(@PathVariable Integer id) {
		return service.getById(id);
	}
	
	@GetMapping("/patient/{id}")
	public List<Doctor> getByPatientId(@PathVariable("id") int id) {
		System.out.println(id+"hello ");
		return service.getByPatientId(id);
	}
	
	@PutMapping("/{id}")
	public Doctor updateDetail(@RequestBody Doctor doctor, @PathVariable Integer id) {
		doctor.setId(id);
		Doctor dr= service.updateDetail(doctor);
		return dr;
	}
	
	@PatchMapping("/{id}")
	public Doctor updateDetailByPatch(@RequestBody Doctor doctor, @PathVariable Integer id) {
		doctor.setId(id);
		Doctor dr= service.updateDetailByPatch(doctor);
		return dr;
	}
	
	@DeleteMapping("/{id}")
	public boolean remove(@RequestBody Doctor doctor, @PathVariable Integer id) {
		doctor.setId(id);
			Boolean b=	service.remove(doctor);
		
	return b;	
	}
}
