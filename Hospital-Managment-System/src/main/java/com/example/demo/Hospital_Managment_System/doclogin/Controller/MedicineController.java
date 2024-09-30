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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Hospital_Managment_System.doclogin.Repository.MedicineRepository;
import com.example.demo.Hospital_Managment_System.doclogin.entity.Medicine;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {
	
	
	private MedicineRepository medicineRepository;
	
	
	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
		
	}

    @PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
		
	}
    @GetMapping("/medicines")
    public List<Medicine>getAllMedicine(){
		return medicineRepository.findAll();
    	
    }
    
    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById( @PathVariable long id ) throws AttributeNotFoundException{
    	
    	 Medicine medicine=medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found by id"));
		return ResponseEntity.ok(medicine) ;
    }
    
    
    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable long id,@RequestBody Medicine medicineDetails) throws AttributeNotFoundException{
    	Medicine medicine=medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found by id"));
    	
    	medicine.setDrugName(medicineDetails.getDrugName());
    	medicine.setStock(medicineDetails.getStock());
    	
    	medicineRepository.save(medicine);
    	
    	
		return ResponseEntity.ok(medicine);
    	
    }
    
    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>>delete(@PathVariable long id) throws AttributeNotFoundException{
    
    	Medicine medicine=medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine are not found by id"));
    	
    	medicineRepository.delete(medicine);
    	Map<String, Boolean> response =new HashMap<String, Boolean>();
    	response.put("Delete", Boolean.TRUE);
    	
    	
		return ResponseEntity.ok(response);
    }
    
    
    
    
    
    
    
    
    
    
    

}
