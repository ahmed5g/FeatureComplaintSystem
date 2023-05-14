import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators , FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import { reclamation } from 'src/app/Models/reclamation';
import { ComplaintService } from 'src/app/Service/reclamations.service';

@Component({
  selector: 'app-add-reclamation',
  templateUrl: './add-reclamation.component.html',
  styleUrls: ['./add-reclamation.component.css']
})
export class AddReclamationComponent implements OnInit {
  addReclamationForm = new FormGroup({
    customerName: new FormControl(""),
    customerEmail: new FormControl(""),
    customerAdress: new FormControl(""),
    orderID: new FormControl(""),
    description: new FormControl(""),
    
  }); 
  constructor(
    private formBuilder: FormBuilder,
    private reclmationService: ComplaintService,
    private router: Router
  ) {}

  ngOnInit(): void {
    
    };
  collectData(): void {

    this.reclmationService.saveReclamation(this.addReclamationForm.value).subscribe((result)=> console.warn(result));
    this.router.navigate(['/ListeReclamations']);
   
  }
}
