import {Component, OnInit} from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";
import {HttpClient} from "@angular/common/http";


@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {
  public currencies: Set<any>;

  constructor(public exchangeService: ExchangeService, private http: HttpClient) {
  }

  ngOnInit() {
    this.exchangeService.getMap().subscribe(data => {
      this.currencies = data;
      console.log()
    })

  }

  private firstCurrency: string;
  private secondCurrency: string;

  setFirstCurrency(value: string) {
    this.firstCurrency = value;
  }//KVIBWDX90RUCR3PW

  setSecondCurrency(value: string) {
    this.secondCurrency = value;
  }

  save() {
    this.exchangeService.postJSON(this.firstCurrency,this.secondCurrency);
  }
}


