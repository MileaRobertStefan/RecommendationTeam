import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-recommendation-component',
  templateUrl: './recommendation-component.component.html',
  styleUrls: ['./recommendation-component.component.css']
})
export class RecommendationComponentComponent implements OnInit {
  private result: Array<{}>

  constructor(private activeRoute: ActivatedRoute, private httpClient: HttpClient) { }
  public get results() {
    return this.result;
  }
  ngOnInit(): void {
    this.activeRoute.url.subscribe(url => {
      const guid = url.pop()
      this.httpClient.get<any>(`http://localhost:3000/api/v1/testmilea/${guid}`).subscribe(data => {
        this.result = data;
        console.log("test1", this.result);
      })
      // const result = this.httpClient.get(`recommandations/${guid}`);
      console.log("test2", this.result);
    });
  };


}

