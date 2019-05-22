import { Component, OnInit } from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";


@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {
  private currencies: Set<any>;

  constructor(public exchangeService: ExchangeService) { }

  ngOnInit() {
    this.exchangeService.getAll().subscribe(data=>{
      this.currencies = data;
    })
  }

  firstCurrency: string;
  secondCurrency: string;


  setCurrency(value: string) {
    this.firstCurrency = value;
  }

  setSecondCurrency(value: string) {
    this.secondCurrency = value;
  }
}

