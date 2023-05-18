import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { reclamation } from 'src/app/Models/reclamation';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {
 apiUrl = 'http://localhost:9090/api/complaint'; 
 apiUrl2= "localhost:9090/api/shipping/complaint";

  constructor(public http:HttpClient){}


  listReclamation(){
    return this.http.get(this.apiUrl + "/");
  }

    saveReclamation(data: any){
      console.warn(data)
      return this.http.post(this.apiUrl + "/add", data);
    }

    
    deleteReclamation(id: any): Observable<any> { 
      return this.http.delete(`${this.apiUrl}/ ${id} ` + "/delete");
    }

    getComplaintById(id: any){
      return this.http.get(`${this.apiUrl}/ ${id}`);

    }

    setShippmentForComplaint(id:any, dataShip: any){
      return this.http.put(`${this.apiUrl2}/ ${id} `, dataShip)
    }
  }
