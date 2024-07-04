package com.module.patient;

import java.util.List;

import com.module.doctor.Doctor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	private String patientName;
	
	private String gender;
	
	private String address;
	@Column(unique = true)
	private String contactNumber;
	
	
	@Transient
	private List<Doctor> doctor;
}
