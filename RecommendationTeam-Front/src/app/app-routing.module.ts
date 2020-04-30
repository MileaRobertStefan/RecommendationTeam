
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Recommendation } from './recommendation/recommendation';
import {AppComponent} from './app.component'

const routes: Routes = [
 { path: '',
  component: AppComponent,
  children:[
    {path:'recommendation', component:Recommendation}
  ]
}
];

@NgModule({
  
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';


// const routes: Routes = [];

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }

