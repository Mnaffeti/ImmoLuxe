                                                                                                                                                                import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { authGuard } from './services/guard/auth.guard';

import { PropertyListComponent } from './properties-list/properties-list.component';
import { AddPropertyComponent } from './add-properties/add-properties.component';
import { UpdatePropertyComponent } from './update-properties/update-properties.component';
import { ShowDetailsComponent } from './show-details/show-details.component';



const routes: Routes = [
  {path:"show-all-properties",component: PropertyListComponent},
  {path:"add-properties", component: AddPropertyComponent},
  {path:'updating-by-id/:id',component:UpdatePropertyComponent},
  {path:'details-of-properties/:id',component:ShowDetailsComponent},
  {path:'home',component:HomeComponent},
  {
    path: '',
    component: HomeComponent,
    canActivate: [authGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
