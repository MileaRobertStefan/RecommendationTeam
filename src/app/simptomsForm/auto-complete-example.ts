import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

/**
 * @title Filter autocomplete
 */

interface Choice {
  value: string;
  viewValue: string;
}
@Component({
  selector: 'auto-complete-example',
  templateUrl: 'auto-complete-example.html',
  styleUrls: ['auto-complete-example.css'],
})
export class AutocompleteFilterExample implements OnInit {
  myControl = new FormControl();
  mySecondControl = new FormControl();
  chosenZone: string;
  options: string[] = ['Cap', 'Stomac', 'Membre'];
  zoneOptions : Object ={Cap:['Migrenă','Amețeală'], Stomac: ['Arsuri', 'Greață'], Membre:['Durere os']};
  filteredOptions: Observable<string[]>
  filteredSecondOptions : Observable<string[]>;
  choices: Choice[] = [
    {value: 'da-0', viewValue: 'Da'},
    {value: 'nu-1', viewValue: 'Nu'}
  ];

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => this._filter(value))
      ),
     this.filteredSecondOptions = this.mySecondControl.valueChanges 
     .pipe(
         startWith(''),
         map(value=>this._filter2(value,this.chosenZone))
     ) ;
     this.filteredOptions.subscribe();
     this.filteredSecondOptions.subscribe();
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();
    this.chosenZone = this.myControl.value;
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
  private _filter2(value: string, chosenZone):string[] {
      const filterValue=value.toLowerCase();
      console.log(this.zoneOptions[chosenZone])
      if(chosenZone !== null){
        return this.zoneOptions[chosenZone].filter(option=>option.toLowerCase().includes(filterValue))
      }
      else {
        return []
      }
  }
}
