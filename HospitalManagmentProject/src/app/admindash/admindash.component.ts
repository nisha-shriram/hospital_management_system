import { Component } from '@angular/core';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';

import { Router } from '@angular/router';
import { AdminauthService } from '../adminauth.service';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrl: './admindash.component.css'
})
export class AdmindashComponent {
  Patients :Patient[]=[];
  constructor(private patientService:PatientService, private adminauthService:AdminauthService, private router:Router){}
  ngOnInit():void{
    this.getPatients();
    }
    getPatients(){
      this.patientService.getPatientList().subscribe(data=>{
        this.Patients=data;
      })
    }
    delete(id:number){
      this.patientService.delete(id).subscribe(data=>{
        console.log(data);
        this.getPatients();
      })
    }
    logout(){
      this.adminauthService.logout();
      this.router.navigate(['home']);

    }
  }


