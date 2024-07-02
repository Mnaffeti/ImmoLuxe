import { Component, OnInit } from '@angular/core';
import { Property } from '../properties';
import { PropertyService } from '../properties.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-properties',
  templateUrl: './add-properties.component.html',
  styleUrls: ['./add-properties.component.css']
})
export class AddPropertyComponent implements OnInit {
  property: Property = new Property();

  constructor(
    private propertyService: PropertyService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  saveProperty() {
    this.propertyService.addProperty(this.property).subscribe(
      data => {
        console.log(data);
        this.goToPropertyList();
      },
      error => console.log(error)
    );
  }

  goToPropertyList() {
    this.router.navigate(['/show-all-properties']);
  }

  onSubmit() {
    console.log(this.property);
    this.saveProperty();
  }

  onCancel() {
    this.router.navigate(['/show-all-properties']);
  }
}
