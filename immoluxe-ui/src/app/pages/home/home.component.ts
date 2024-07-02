import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Property } from '../../properties';
import { PropertyService } from '../../properties.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  
  properties: Property[];
  EnteredID!: number;

  constructor(private propertyService: PropertyService, private router: Router) {
    this.properties = [];
  } 

  ngOnInit(): void {
    this.getProperties();
  }

  goToProperty(): void {
    console.log(this.EnteredID); 
    this.router.navigate(['details-of-properties', this.EnteredID]);
  }

  getProperties(): void {
    this.propertyService.getPropertiesList().subscribe(data => {this.properties = data;});
  }

  updateProperty(id: number): void {
    this.router.navigate(['updating-by-id', id]);
  }

  deleteProperty(id: number): void {
    if(confirm("Are you sure to delete Property ID: "+id)) {
      this.propertyService.deleteProperty(id).subscribe( data => {
        console.log(data);
        this.getProperties();
      })
    }
  }

  detailsOfProperty(id: number): void {
    this.router.navigate(['details-of-properties', id]);
  }
}