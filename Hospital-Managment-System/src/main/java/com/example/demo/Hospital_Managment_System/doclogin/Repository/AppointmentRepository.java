package com.example.demo.Hospital_Managment_System.doclogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Hospital_Managment_System.doclogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
