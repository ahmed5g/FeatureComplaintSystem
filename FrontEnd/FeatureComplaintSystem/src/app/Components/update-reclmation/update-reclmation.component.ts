import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { ComplaintService } from "src/app/Service/reclamations.service";

@Component({
  selector: 'app-update-reclmation',
  templateUrl: './update-reclmation.component.html',
  styleUrls: ['./update-reclmation.component.css']
})
export class UpdateReclmationComponent implements OnInit {

  EditReclamationForm = new FormGroup({
    customerName: new FormControl(""),
    customerEmail: new FormControl(""),
    customerAdress: new FormControl(""),
    orderID: new FormControl(""),
    description: new FormControl("")
  });

  constructor(
    private router: Router,
    private ActivatedRouter: ActivatedRoute,
    private ComplaintService: ComplaintService,
    private toast: NgToastService,
  ) { }

  ngOnInit(): void {
    console.warn(this.ActivatedRouter.snapshot.params['id']);
    this.ComplaintService.getComplaintById(this.ActivatedRouter.snapshot.params['id']).subscribe((result) => {
      console.warn(result);
      this.EditReclamationForm = new FormGroup({
        customerName: new FormControl(""),
        customerEmail: new FormControl(""),
        customerAdress: new FormControl(""),
        orderID: new FormControl(""),
        description: new FormControl("")
  
      }) 
    });
  }
}

