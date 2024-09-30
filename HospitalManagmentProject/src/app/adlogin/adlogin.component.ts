import { Component } from '@angular/core';
import { AdminauthService } from '../adminauth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adlogin',
  templateUrl: './adlogin.component.html',
  styleUrl: './adlogin.component.css'
})
export class AdloginComponent {

  username:string="";
  password:string="";
  invalidLogin=false;

constructor(private adminauthService:AdminauthService, private router:Router){
  

}
checkLogin(){
  if(this.adminauthService.authenticate(this.username,this.password)){

this.router.navigate(['admin']);
this.invalidLogin=false;
    
  }else
  {
    this.invalidLogin=true;
    alert("wrong credentials")

    this.router.navigate(['home']);
  }
}
}
