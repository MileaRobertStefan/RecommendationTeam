import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';
import {Observable} from 'rxjs';
import {map, startWith} from 'rxjs/operators';

/**
 * @title Filter autocomplete
 */
@Component({
  selector: 'auto-complete-example',
  templateUrl: 'auto-complete-example.html',
  styleUrls: ['auto-complete-example.css'],
})
export class AutocompleteFilterExample implements OnInit {
  myControl = new FormControl();
  mySecondControl = new FormControl();
  chosenZone: string;
  options: string[] = ['Cap', 'Stomac', 'Muschi'];
  zoneOptions : Object ={Cap:['Migrena','Ameteala'], Stomac: ['Arsuri', 'Greata'], Muschi:['Durere os']};
  filteredOptions: Observable<string[]>
  filteredSecondOptions : Observable<string[]>;

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
    console.log(this.chosenZone)
  
    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
  private _filter2(value: string, chosenZone):string[] {
      const filterValue=value.toLowerCase();
      console.log(this.mySecondControl)
      if(chosenZone !== null){ 
        return this.zoneOptions[chosenZone].filter(option=>option.toLowerCase().includes(filterValue))
      }
      return this.zoneOptions[chosenZone];
  }
}
