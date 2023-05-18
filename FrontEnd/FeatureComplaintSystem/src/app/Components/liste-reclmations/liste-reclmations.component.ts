import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { never } from 'rxjs';
import { ComplaintService } from 'src/app/Service/reclamations.service';
import{Location} from '@angular/common'


@Component({
  selector: 'app-liste-reclmations',
  templateUrl: './liste-reclmations.component.html',
  styleUrls: ['./liste-reclmations.component.css']
})
export class ListeReclmationsComponent implements OnInit{
  data: any;
  collection:any=[]
  searchText=''



  constructor(
    private reclmationService: ComplaintService,
    private router: Router,
    private location: Location
  ){
    reclmationService.listReclamation().subscribe(data=>{
      console.warn(data)
      this.data=data
    }
    )

  }
 ngOnInit(): void {
   
 }
 

 
  suprimeData(item: any){

    console.warn(this.collection)
    this.collection.splice(item-1,1)
    this.reclmationService.deleteReclamation(item).subscribe((result)=> console.warn(result));
    this.location.go(this.location.path());

   
  }
}


