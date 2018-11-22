import { Injectable } from "@angular/core";
import { Http, RequestOptions, Headers, Response } from "@angular/http";
import { Observable } from "rxjs";
import { map } from "rxjs/operators";
import { Politician } from "../models/politician";
import { Statement } from "@angular/compiler";
import { Party } from "../models/Party";
import { Statistics } from "../models/Statistics";
import { User } from "../components/user/user";


@Injectable({
  providedIn: "root"
})
export class CardsService {
  politiciansUrl: string;
  partiesUrl: string;
  pStatsUrl: string;
  searchUrl: string;

  constructor(private http: Http) {
    this.politiciansUrl = "http://localhost:6556/politician";
    this.partiesUrl = "http://localhost:6556/parties";
    this.pStatsUrl = "http://localhost:6556/stats";
    this.searchUrl = "http://localhost:6556/politician/";
  }

  getPoliticianUrl(state: string): string {
    return this.politiciansUrl + "/" + state;
  }
  getPoliticianIdUrl(id: Number): string {
    return this.politiciansUrl + "/id/" + id;
  }
  getPoliticianStatsUrl(id: Number): string {
    return this.pStatsUrl + "/" + id;
  }

  getSearchUrl(field: String, srchVal: String) {
    console.log(this.searchUrl + field + "/" + srchVal);
    return(this.searchUrl + field + "/" + srchVal);

  }

  searchPoliticiansById(id: Number): Observable<Politician> {
    return this.http
      .get(this.getPoliticianIdUrl(id))
      .pipe(map(data => data.json()));
  }


  
  searchPoliticians(state: string): Observable<Politician[]> {
    return this.http
      .get(this.getPoliticianUrl(state))
      .pipe(map(data => data.json()));
  }
  getAllParties(): Observable<Party[]> {
    return this.http.get(this.partiesUrl).pipe(map(data => data.json()));
  }
  getAllStats(): Observable<Number[]> {
    return this.http
      .get(this.pStatsUrl + "/totalCount")
      .pipe(map(data => data.json()));
  }
  getPopular(): Observable<Politician[]> {
    return this.http
      .get(this.pStatsUrl + "/popular")
      .pipe(map(data => data.json()));
  }

  getStatByPoliticianId(id: Number): Observable<Statistics> {
    return this.http
      .get(this.getPoliticianStatsUrl(id))
      .pipe(map(data => data.json()));
  }

  navSearch(field: String, srchVal: String): Observable<Politician[]> {
    return this.http
      .get(this.getSearchUrl(field, srchVal))
      .pipe(map(data => data.json()));
      
  }
}
