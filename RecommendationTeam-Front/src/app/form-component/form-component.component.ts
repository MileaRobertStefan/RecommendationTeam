
import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl, ValidationErrors } from '@angular/forms';
import { Event, NavigationStart, NavigationEnd, NavigationError, NavigationCancel, ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router'
import { HttpClient, HttpResponse } from '@angular/common/http'
import { Injectable } from '@angular/core'
interface Choice {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'app-form-component',
  templateUrl: './form-component.component.html',
  styleUrls: ['./form-component.component.css']
})
export class FormComponentComponent implements OnInit {

  totalAngularPackages;
  isLinear = true;
  firstFormGroup: FormGroup;
  secondFormGroup: FormGroup;
  thirdFormGroup: FormGroup;
  sliderValue: number;
  response: Object[];
  options: string[];
  chosenZoneOptions: string[];
  zoneOptions: Object;
  filteredOptions: string[];
  filteredSecondOptions: string[];
  route: ActivatedRoute;

  jsonObject = {
    simptoms: {
      bodyPart: '',
      simptomType: '',
      sick: false,
      lastControlDate: ''
    },
    info: {
      sameAddress: true,
      actualAdress: '',
      medic: '',
      clinic: '',
      priceLimit: 0
    }
  }


  choices: Choice[] = [
    { value: 'da', viewValue: 'Da' },
    { value: 'nu', viewValue: 'Nu' }
  ];


  choicesThirdStep: Choice[] = [
    { value: 'da', viewValue: 'Da' },
    { value: 'nu', viewValue: 'Nu' }
  ];



  anotherchoices: Choice[] = [
    { value: 'barbat', viewValue: 'Bărbat' },
    { value: 'femeie', viewValue: 'Femeie' }
  ];


  thirdchoices: Choice[] = [
    { value: 'privat', viewValue: 'Privat' },
    { value: 'stat', viewValue: 'De stat' }
  ];

  constructor(private _formBuilder: FormBuilder, private http: HttpClient, private router: Router) {
    // router.events.subscribe((routerEvent: Event) => {
    //   this.checkRouterEvent(routerEvent);
    // });
  }
  loading = true;
  checkRouterEvent(routerEvent: Event): void {
    if (routerEvent instanceof NavigationStart) {
      this.loading = true;
    }

    if (routerEvent instanceof NavigationEnd ||
      routerEvent instanceof NavigationCancel ||
      routerEvent instanceof NavigationError) {
      this.loading = false;
    }
  }
  goToItems() {
    this.router.navigate(['items'], { relativeTo: this.route });
  }


  ngOnInit() {
    this.getSimptoms()
    console.log("lalala", this.response)
    this.firstFormGroup = this._formBuilder.group({
      bodyPartControl: [''],
      simptomTypeControl: ['', Validators.required],
      chronicDeseaseControl: ['', Validators.required],
      lastDateControl: ['', Validators.required],
    });
    this.thirdFormGroup = this._formBuilder.group({
      locationControl: ['', Validators.required],
      newLocationControl: ['', Validators.required],
      medicControl: ['', Validators.required],
      clinicControl: ['', Validators.required]
    })

    this.firstFormGroup.controls.bodyPartControl.valueChanges.subscribe(() => {
      this.firstFormGroup.controls.simptomTypeControl.reset();
    });
  }


  getValuesStepOne() {

    this.jsonObject.simptoms.bodyPart = this.firstFormGroup.controls.bodyPartControl.value;
    this.jsonObject.simptoms.simptomType = this.firstFormGroup.controls.simptomTypeControl.value;
    if (this.firstFormGroup.controls.chronicDeseaseControl.value === 'da')
      this.jsonObject.simptoms.sick = true;
    this.jsonObject.simptoms.lastControlDate = this.firstFormGroup.controls.lastDateControl.value;

  }


  formatLabel(sliderValue: number) {
    if (sliderValue >= 10) {
      return Math.round(sliderValue / 10);
    }
    return sliderValue;
  }

  public bigTool: Object = { isVisible: true, format: '#####' };

  updateValue(event) {
    this.sliderValue = event.value;
  }

  getCurrentInfo() {
    if (this.thirdFormGroup.controls.locationControl.value === 'nu')
      this.jsonObject.info.sameAddress = false;
    this.jsonObject.info.actualAdress = this.thirdFormGroup.controls.newLocationControl.value;
    this.jsonObject.info.medic = this.thirdFormGroup.controls.medicControl.value;
    this.jsonObject.info.clinic = this.thirdFormGroup.controls.clinicControl.value;
    this.jsonObject.info.priceLimit = this.sliderValue;
  }

  private getSimptoms() {
    this.http.get<any>('https://recommendation-team.herokuapp.com/api/v1/recommendation').subscribe(data => {
      this.setOptions(data[0].options);
      this.zoneOptions = data[0];
      this.filteredOptions = data[0]["options"];
    })

    console.log('I will not wait until subscribe is executed..');
    console.log(this.options);
  }

  public get symptoms() {
    return this.zoneOptions[this.firstFormGroup.controls.bodyPartControl.value];
  }



  setOptions(vector) {
    this.options = vector;
  }
  sendJson() {
    const json = JSON.stringify(this.jsonObject);
    console.log(this.jsonObject);
    this.http.post<any>('https://recommendation-team.herokuapp.com/api/v1/recommendation', { simptoms: this.jsonObject.simptoms, info: this.jsonObject.info })
      .subscribe((response) => {
        const guid: string = response['guid'];
        console.log("aiiiciiii", guid);
        this.router.navigate(["second-component", guid]);
      });
  }

  // sendJson() {
  //   //     console.log(this.options+ " 3");
  //   const json = JSON.stringify(this.jsonObject);
  //   console.log(this.jsonObject);
  //   this.http.post<any>('http://localhost:3000/api/v1/recommendation', { simptoms: this.jsonObject.simptoms, info: this.jsonObject.info }).subscribe(data => {
  //     console.log(data);
  //     this.response = [...data];
  //     // this.jsonObject = data['jsonObject']; 
  //   });
  //   // console.log("testul lui milea " +this.response);

  //   //  console.log("testul lui milea 2" +this.response);
  // }
}
