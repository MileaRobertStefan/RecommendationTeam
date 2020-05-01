
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecommendationComponentComponent } from './recommendation-component/recommendation-component.component';
import {FormComponentComponent} from './form-component/form-component.component'

const routes: Routes = [
  {path: '', component: FormComponentComponent },
  {path: 'first-component', component: FormComponentComponent },
  { path: 'second-component', component: RecommendationComponentComponent },
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true } )],
  exports: [RouterModule]
})
export class AppRoutingModule {}

export const routesConstants =[FormComponentComponent,RecommendationComponentComponent];


