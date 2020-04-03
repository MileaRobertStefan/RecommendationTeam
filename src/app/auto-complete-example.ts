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
  options: string[] = ['Cap', 'Stomac', 'Muschi'];
  zoneOptions : string[] =['Migrena','Ameteala', 'Arsuri', 'Greata','Durere os'];
  filteredOptions: Observable<string[]>;
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
         map(value=>this._filter2(value))
     ) ;
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }
  private _filter2(value: string):string[] {
      const filterValue=value.toLowerCase();
      return this.zoneOptions.filter(option=>option.toLowerCase().includes(filterValue))
  }
}

