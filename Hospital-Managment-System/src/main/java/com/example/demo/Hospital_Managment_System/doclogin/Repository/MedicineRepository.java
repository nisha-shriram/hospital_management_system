package com.example.demo.Hospital_Managment_System.doclogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Hospital_Managment_System.doclogin.entity.Medicine;
@Repository
public interface MedicineRepository  extends JpaRepository<Medicine,Long> {
	

}
