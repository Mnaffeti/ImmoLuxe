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
    const formData = new FormData();
    
    // Append photo file if selected
    if (this.property.photo) {
      formData.append('photo', this.property.photo);
    }

    // Append other property data
    formData.append('type', this.property.type);
    formData.append('bedrooms', this.property.bedrooms.toString());
    formData.append('address', this.property.address);
    formData.append('price', this.property.price.toString());
    formData.append('bathrooms', this.property.bathrooms.toString());
    formData.append('area', this.property.area.toString());
    formData.append('description', this.property.description);

    this.propertyService.addProperty(formData).subscribe(
      data => {
        console.log('Property added successfully:', data);
        this.goToPropertyList();
      },
      error => console.error('Error adding property:', error)
    );
  }

  goToPropertyList() {
    this.router.navigate(['/show-all-properties']);
  }

  onSubmit() {
    console.log('Submitting property:', this.property);
    this.saveProperty();
  }

  onCancel() {
    this.router.navigate(['/show-all-properties']);
  }

  onFileSelected(event: Event) {
    const inputElement = event.target as HTMLInputElement;
    if (inputElement?.files && inputElement.files.length > 0) {
      this.property.photo = inputElement.files[0];
    }
  }
}
