import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ObjectExchange} from "../../exchange/exchange.component";

@Injectable({
  providedIn: 'root'
})
export class ExchangeService {

  constructor(private http: HttpClient) { }

  getAll():Observable<any>{
    return this.http.get('//localhost:8080/list')
  }

  getMap():Observable<ObjectExchange>{
    return this.http.get<ObjectExchange>('//localhost:8080/obj');
  }


}
