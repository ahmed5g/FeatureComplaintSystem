import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { ComplaintService } from 'src/app/Service/reclamations.service';

@Component({
  selector: 'app-shipping-page',
  templateUrl: './shipping-page.component.html',
  styleUrls: ['./shipping-page.component.css']
})
export class ShippingPageComponent implements OnInit {
  addShippmentForm = new FormGroup({
    sender_address: new FormControl(""),
    recipient_address: new FormControl(""),
    shipping_cost: new FormControl(""),
    replacement_item: new FormControl(""),
    Recipient_latitude: new FormControl(""),
    Recipient_longitude: new FormControl("")
  });

  data: any;

  constructor(
    private formBuilder: FormBuilder,
    private reclmationService: ComplaintService,
    private router: Router,
    private toast: NgToastService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    console.warn(this.route.snapshot.params['id']);
    this.reclmationService.getComplaintById(this.route.snapshot.params['id']).subscribe((result) => {
      console.warn(result);
    });
  }

  collectData(item: any): void {
    this.reclmationService.setShippmentForComplaint(item,this.addShippmentForm.value).subscribe((result) => {
      console.warn(result);
      this.router.navigate(['/ListeReclamations']);
      this.toast.success({ detail: "SUCCESS", summary: 'Reclamation Bien reçue', duration: 5000 });
    });
  }
}
