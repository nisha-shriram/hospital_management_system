import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DocauthService {

  constructor() { }

  authenticate(username:string,password:string){
    if(username=="Nisha"&&password=="nisha111"){
      sessionStorage.setItem('username',username);
      return true;
    }else{
      return false;
    }
  }

  isUserLoggedIn(){
    console.log("Doctor login ho gye!!")
    let user=sessionStorage.getItem('username');
    return !(user==null);
  }
  logout(){
    console.log("Doctor logout go gye!!")
    sessionStorage.removeItem('username');
  }
}
