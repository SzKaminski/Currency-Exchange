import {Component, OnInit} from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";


@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {
  public currencies: Set<any>;
  private curries: Curries;

  constructor(public exchangeService: ExchangeService) {
  }

  ngOnInit() {
    this.exchangeService.getMap().subscribe(data => {
      this.currencies = data;
      console.log()
    })
  }

  private firstCurrency: string;
  private secondCurrency: string;
  private rateResponse: Curries;

  setFirstCurrency(value: string) {
    this.firstCurrency = value;

  }//KVIBWDX90RUCR3PW

  setSecondCurrency(value: string) {
    this.secondCurrency = value;
  }


  save() {
    this.curries = {
      firstCur: this.firstCurrency,
      secondCur: this.secondCurrency,
    };
    this.exchangeService.postJSON(this.curries).subscribe(data => {
      this.rateResponse = data;
      console.log(this.rateResponse);
    });
  }
}

export interface Curries {

  firstCur: string;
  secondCur: string;

}
