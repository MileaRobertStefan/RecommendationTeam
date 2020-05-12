
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RecommendationComponentComponent } from './recommendation-component/recommendation.component';
import { FormComponentComponent } from './form-component/form.component'

const routes: Routes = [
  { path: '', component: FormComponentComponent },
  { path: 'form', component: FormComponentComponent },
  { path: 'recommendation/:id', component: RecommendationComponentComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routesConstants = [FormComponentComponent, RecommendationComponentComponent];


