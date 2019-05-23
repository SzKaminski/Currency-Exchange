import {Component, OnInit} from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";


@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {
  private currencies: ObjectExchange;

  constructor(public exchangeService: ExchangeService) {
  }

  /*ngOnInit() {
    this.exchangeService.getAll().subscribe(data => {
      this.currencies = data;
    })
  }*/
  ngOnInit() {
    /*this.exchangeService.getMap().subscribe(data => {
      this.currencies = data;
      console.log(data.parameters)
    }*/

    this.exchangeService.getAll().subscribe(data => {
      this.currencies = data;
    })
  }

  firstCurrency: string;
  secondCurrency: string;


  setFirstCurrency(value: string) {
    this.firstCurrency = value;
  }

  setSecondCurrency(value: string) {
    this.secondCurrency = value;
  }
}

export interface JsonResponse {
  parameters: { [name: string]: number };
}

export class ObjectExchange {
  parameters: Map<string, number>;

  constructor(json: JsonResponse) {
    this.parameters = new Map<string, number>();
    Object.keys(json.parameters).forEach(key => {
      this.addParameter(key, json.parameters[key]);
    });
  }

  addParameter(key: string, value: number) {
    this.parameters.set(key, value);
  }

  getParameters() {
    return this.parameters;
  }
}

/*name: Set<string>;
rate: number;
}*/

