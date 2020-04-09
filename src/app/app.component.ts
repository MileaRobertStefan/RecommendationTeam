
import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormControl} from '@angular/forms';
import { Observable } from 'rxjs';
import { startWith, map } from 'rxjs/operators';

interface Choice {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  isLinear =true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup:FormGroup;
  chosenZoneOptions: string[];
  options: string[] = ['Cap', 'Stomac', 'Membre'];
  zoneOptions : Object ={Cap:['Migrenă','Amețeală'], Stomac: ['Arsuri', 'Greață'], Membre:['Durere os']};
  filteredOptions: Observable<string[]>
  filteredSecondOptions : Observable<string[]>;
  choices: Choice[] = [
    {value: 'da-0', viewValue: 'Da'},
    {value: 'nu-1', viewValue: 'Nu'}
  ];


  choicesThirdStep: Choice[] = [
    {value: 'da-0', viewValue: 'Da'},
    {value: 'nu-1', viewValue: 'Nu'}
  ];

  

  anotherchoices: Choice[] = [
    {value: 'barbat-0', viewValue: 'Bărbat'},
    {value: 'femeie-1', viewValue: 'Femeie'}
  ];


  thirdchoices: Choice[] = [
    {value: 'privat-0', viewValue: 'Privat'},
    {value: 'stat-1', viewValue: 'De stat'}
  ];


  constructor(private _formBuilder: FormBuilder) {}



  ngOnInit() {

    this.firstFormGroup = this._formBuilder.group({
      bodyPartControl: [''],
      simptomTypeControl : ['', Validators.required],
      chronicDeseaseControl : ['', Validators.required],
      lastDateControl  : ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      locationControl: ['', Validators.required],
      newLocationControl: ['', Validators.required],
      medicControl: ['', Validators.required],
    })
   


    this.filteredOptions = this.firstFormGroup.controls.bodyPartControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      ),
     this.filteredSecondOptions = this.firstFormGroup.controls.simptomTypeControl.valueChanges 
     .pipe(
         startWith(''),
         map(value=>this._filter2(value))
     ) ;
     this.filteredOptions.subscribe();
     this.filteredSecondOptions.subscribe();
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    console.log(typeof this.firstFormGroup.controls.bodyPartControl.value)
    
    const chosenZone = this.firstFormGroup.controls.bodyPartControl.value;
    this.chosenZoneOptions=this.zoneOptions[chosenZone];
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
  private _filter2(value: string):string[] {
      const filterValue=value.toLowerCase();
      console.log(filterValue)
      if(this.chosenZoneOptions!==undefined){
        return this.chosenZoneOptions.filter(option=>option.toLowerCase().includes(filterValue))
      }
      else {
        return []
      }
  }

  formatLabel(value: number) {
    if (value >= 10) {
      return Math.round(value / 10);
    }

    return value;
  }

}













