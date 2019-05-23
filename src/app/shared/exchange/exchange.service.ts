import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {map, catchError} from "rxjs/operators";

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

}
