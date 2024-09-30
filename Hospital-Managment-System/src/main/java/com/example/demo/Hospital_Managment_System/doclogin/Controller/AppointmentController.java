package com.example.demo.Hospital_Managment_System.doclogin.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Hospital_Managment_System.doclogin.Repository.AppointmentRepository;
import com.example.demo.Hospital_Managment_System.doclogin.entity.Appointment;

import aj.org.objectweb.asm.Attribute;



@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v2")
public class AppointmentController {
	
	private AppointmentRepository appointmentRepository;

	public AppointmentController(AppointmentRepository appointmentsRepository) {
		super();
		this.appointmentRepository = appointmentsRepository;
	}
	@PostMapping("/appointments")
	public Appointment createAppointment(@RequestBody  Appointment appointment) {
		return appointmentRepository.save(appointment);
		
		
	}
	@GetMapping("/appointments")
    public List<Appointment>getAllAppointment(){
		return appointmentRepository.findAll();
    	
    }
	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteAppointment(@PathVariable long id) throws AttributeNotFoundException{
		
		Appointment appointment = appointmentRepository.findById(id).orElseThrow( ()-> new AttributeNotFoundException("Appointment not found with id"+id));
		
		appointmentRepository.delete(appointment);
		Map<String,Boolean> response=new HashMap<String,Boolean>();
		
		response.put("Deleted",Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
	

}

