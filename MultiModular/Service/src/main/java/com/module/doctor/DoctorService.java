package com.module.doctor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.dctor.DoctorRepo;
import com.module.doctor.Doctor;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepo repo;

	public Doctor save(Doctor doctor) {
		return repo.save(doctor);
	}

	public List<Doctor> getAll() {
		List<Doctor> dr = repo.findAll();
		return dr;
	}

	public Doctor getById(Integer id) {
		Doctor dr = repo.findById(id).get();
		return dr;
	}

	public List<Doctor> getByPatientId(Integer patientId) {
		System.out.println("hello doc ");
		List<Doctor> dr = repo.findByPatientId(patientId);
		System.out.println(dr);
		return dr;
	}

	public Doctor updateDetail(Doctor doctor) {
		Doctor dr = repo.findById(doctor.getId()).get();
		if (dr != null) {
			repo.save(doctor);
		}
		return doctor;
	}

	public Doctor updateDetailByPatch(Doctor doctor) {
		Doctor dr = repo.findById(doctor.getId()).get();
		if (dr != null) {
			repo.save(doctor);
		}
		return doctor;
	}

	public Boolean remove(Doctor doctor) {
		Doctor dr = repo.findById(doctor.getId()).get();

		if (dr != null) {
			repo.deleteById(doctor.getId());
			return true;
		}
		return false;
	}

}
