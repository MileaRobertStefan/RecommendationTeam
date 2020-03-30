import {Component} from '@angular/core';

interface Choice {
  value: string;
  viewValue: string;
}

interface AnotherChoices {
    value: string;
    viewValue: string;
}

interface ThirdChoices {
    value: string;
    viewValue: string;
}

/**
 * @title Basic select
 */
@Component({
  selector: 'addition',
  templateUrl: 'addition.html',
  styleUrls: ['addition.css'],
})
export class SelectOverviewExample {
  choices: Choice[] = [
    {value: 'da-0', viewValue: 'Da'},
    {value: 'nu-1', viewValue: 'Nu'}
  ];

  anotherchoices: AnotherChoices[] = [
    {value: 'barbat-0', viewValue: 'Bărbat'},
    {value: 'femeie-1', viewValue: 'Femeie'}
  ];

  thirdchoices: ThirdChoices[] = [
    {value: 'privat-0', viewValue: 'Privat'},
    {value: 'stat-1', viewValue: 'De stat'}
  ];

  formatLabel(value: number) {
    if (value >= 10) {
      return Math.round(value / 10);
    }

    return value;
  }
}
