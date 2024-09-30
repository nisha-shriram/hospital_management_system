package com.example.demo.Hospital_Managment_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Hospital_Managment_System.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
 