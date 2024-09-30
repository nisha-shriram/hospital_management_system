import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminauthService {

  constructor() { }
  authenticate(username2:string,password2:string){
    if(username2=="Nisha"&& password2=="nishh"){
      sessionStorage.setItem('username2',username2);
      return true;
    }else{
       return false;
    }

  }
  isUserLoggedIn(){
    console.log("user login ho gaya hai")
    let user=sessionStorage.getItem('username2');

    return !(user==null)
  }
  logout(){
    console.log("admin logout ho gya!!!")
    sessionStorage.removeItem('username2');

  }
}
