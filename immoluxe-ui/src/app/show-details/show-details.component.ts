import { Component, OnInit } from '@angular/core';
import { Property } from '../properties';
import { PropertyService } from '../properties.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

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
  totalClicks: number = 0;

  // ngx-charts data and options
  clicksByDay: any[] = [];
  clicksByMonth: any[] = [];

  view: any[] = [700, 400]; // Chart view dimensions
  colorScheme = {
    domain: ['#5AA454', '#A10A28', '#C7B42C', '#AAAAAA']
  };
  gradient = false;
  showLegend = true;
  showXAxis = true;
  showYAxis = true;
  showXAxisLabel = true;
  xAxisLabel = 'Date';
  showYAxisLabel = true;
  yAxisLabel = 'Clicks';

  gaugeValue: number = 0;
  gaugeLabel: string = 'Total Clicks';
  gaugeAppendText: string = 'clicks';

  constructor(
    private route: ActivatedRoute,
    private propertyService: PropertyService,
    private http: HttpClient
  ) {
    this.id = 0;
    this.dataSource = [];
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    
    // Fetch clicks from API
    this.http.get<any[]>('http://localhost:8080/api/v1/clicks').subscribe(clicks => {
      console.log('Clicks fetched:', clicks);
      
      // Example: Group clicks by day and month
      this.clicksByDay = this.groupClicksByDay(clicks);
      console.log('Clicks by day:', this.clicksByDay);
      
      this.clicksByMonth = this.groupClicksByMonth(clicks);
      console.log('Clicks by month:', this.clicksByMonth);

      // Calculate total clicks
      this.totalClicks = clicks.length;
      this.gaugeValue = this.totalClicks;
    }, error => {
      console.error('Error fetching clicks:', error);
    });

    // Fetch property details
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
    }, error => {
      console.error('Error fetching property details:', error);
    });
  }

  // Helper function to group clicks by day
  groupClicksByDay(clicks: any[]): any[] {
    const clicksByDayMap = new Map<string, number>();
    clicks.forEach(click => {
      const dayKey = new Date(click.timestamp).toLocaleDateString();
      if (clicksByDayMap.has(dayKey)) {
        clicksByDayMap.set(dayKey, clicksByDayMap.get(dayKey)! + 1);
      } else {
        clicksByDayMap.set(dayKey, 1);
      }
    });
    return Array.from(clicksByDayMap.entries()).map(([name, value]) => ({ name, value }));
  }

  // Helper function to group clicks by month
  groupClicksByMonth(clicks: any[]): any[] {
    const clicksByMonthMap = new Map<string, number>();
    clicks.forEach(click => {
      const monthKey = new Date(click.timestamp).toLocaleString('default', { month: 'long' });
      if (clicksByMonthMap.has(monthKey)) {
        clicksByMonthMap.set(monthKey, clicksByMonthMap.get(monthKey)! + 1);
      } else {
        clicksByMonthMap.set(monthKey, 1);
      }
    });
    return Array.from(clicksByMonthMap.entries()).map(([name, value]) => ({ name, value }));
  }

  onSelect(event: any): void {
    console.log(event);
  }
}
