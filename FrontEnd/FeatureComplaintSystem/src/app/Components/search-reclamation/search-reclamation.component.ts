import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-reclamation',
  templateUrl: './search-reclamation.component.html',
  styleUrls: ['./search-reclamation.component.css']
})
export class SearchReclamationComponent implements OnInit{



  constructor(){}




  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


  enteredSearchValue:string='';

  @Output()
  enteredSearchChanged : EventEmitter<string> = new EventEmitter<string>()

  Onseach(){
    this.enteredSearchChanged.emit(this.enteredSearchValue);
  }

}
