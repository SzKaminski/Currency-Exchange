import {Component, OnInit} from '@angular/core';
import {ExchangeService} from "../shared/exchange/exchange.service";
import {Chart} from 'chart.js';

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
    });


    this.LineChart = new Chart('lineChart',{
      type: 'line',

      data: {
        labels: ["Jan","Feb","March"],
        datasets: [{
          data: [9, 4, 14],
          lineTension: 0.2,
          borderColor: "red",
          borderWidth: 1
        }]
      },
      options: {
        title: {
          text:"line",
          display:true
        },
        scales:{
          yAxes:[{
            ticks:{
              beginAtZero: true
            }
          }]
        }
      }
    })
  }

  LineChart = [];


  public firstCurrency: string;
  public secondCurrency: string;
  public rateResponse: Curries;

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

  getChartData() {
    this.curries = {
      firstCur: this.firstCurrency,
      secondCur: this.secondCurrency,
    };
    this.exchangeService.postJsonForChart(this.curries).subscribe(data => {
      this.rateResponse = data;
      console.log(this.rateResponse);
    });
  }
}

export interface Curries {

  firstCur: string;
  secondCur: string;

}
