import {Injectable} from '@angular/core';
import {HttpClient, HttpHandler, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {Curries} from "../../exchange/exchange.component";

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/list')
  }

  public currencies = [];

  getMap(): Observable<any> {
    return this.http.get('//localhost:8080/obj')
      .pipe(
        map((data: any[]) => {
          return this.currencies = data;
        }), catchError(error => {
          return throwError('Something went wrong!')
        })
      )
  }


  postJsonForChart(curries: Curries): Observable<Curries> {
    return this.http.post<Curries>("//localhost:8080/historicalChart", curries, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
  }


  postJSON(curries: Curries): Observable<Curries> {
    return this.http.post<Curries>("//localhost:8080/exchangeCurrencies", curries, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    })
  }

}


