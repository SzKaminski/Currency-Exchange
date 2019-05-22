import { Component, OnInit } from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";

@Component({
  selector: 'app-currency-map',
  templateUrl: './currency-map.component.html',
  styleUrls: ['./currency-map.component.css']
})
export class CurrencyMapComponent implements OnInit {

  private currencies: Set<any>;

  constructor(public exchangeService: ExchangeService) { }

  ngOnInit() {
    this.exchangeService.getAll().subscribe(data=>{
      this.currencies = data;
    })
  }

}
