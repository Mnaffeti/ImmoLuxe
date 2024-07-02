import { Component, OnInit } from '@angular/core';
import { Property } from '../properties';
import { PropertyService } from '../properties.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-details',
  templateUrl: './show-details.component.html',
  styleUrls: ['./show-details.component.css']
})
export class ShowDetailsComponent implements OnInit {

  id: number;
  property!: Property;
  displayedColumns: string[] = ['attribute', 'value'];
  dataSource: any[];

  constructor(
    private route: ActivatedRoute,
    private propertyService: PropertyService
  ) {
    this.id = 0;
    this.dataSource = [];
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.property = new Property();
    this.propertyService.getPropertyById(this.id).subscribe(data => {
      this.property = data;
      this.dataSource = [
        { attribute: 'Id', value: this.property.id },
        { attribute: 'Address', value: this.property.address },
        { attribute: 'Type', value: this.property.type },
        { attribute: 'Price', value: this.property.price },
        { attribute: 'Bedrooms', value: this.property.bedrooms },
        { attribute: 'Bathrooms', value: this.property.bathrooms },
        { attribute: 'Area', value: this.property.area },
        { attribute: 'Description', value: this.property.description },
      ];
    });
  }
}
