import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { MatTabsModule } from '@angular/material/tabs';
import {DemoMaterialModule} from './material-module'
import {AutocompleteFilterExample} from './simptomsForm/auto-complete-example'
import {MAT_FORM_FIELD_DEFAULT_OPTIONS} from '@angular/material/form-field';
import {SelectOverviewExample} from './addition'
// import {MdSelectModule} from '@angular/material/select';

@NgModule({
  declarations: [
    AppComponent,
    AutocompleteFilterExample,
    SelectOverviewExample
  ],
  imports: [
 // MdSelectModule,
   MatTabsModule,
 FormsModule,
 ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    DemoMaterialModule
  ],
  entryComponents:[AutocompleteFilterExample, SelectOverviewExample],
  providers: [ { provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: { appearance: 'legacy' } }],
  bootstrap: [AppComponent, AutocompleteFilterExample, SelectOverviewExample],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
