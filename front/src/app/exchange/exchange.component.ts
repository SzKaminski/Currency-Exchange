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

    this.LineChart = new Chart('lineChart', {
      type: 'line',
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    })
  }

  LineChart = [];

  chartDateTime = [];
  chartHighRate = [];


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
      if (this.rateResponse != null){
        this.getChartData();
      }
    });
  }

  private chartArray: Array<ChartData>;

  getChartData() {
    this.curries = {
      firstCur: this.firstCurrency,
      secondCur: this.secondCurrency,
    };
    this.exchangeService.postJsonForChart(this.curries).subscribe(data => {
      this.chartArray = JSON.parse(JSON.stringify(data));

      for (let entry of this.chartArray) {
        this.chartDateTime.push(entry.dateTime);
        this.chartHighRate.push(entry.highRate);
      }

      this.LineChart = new Chart('lineChart', {
        type: 'line',

        data: {
          labels: this.chartDateTime,
          datasets: [{
            data: this.chartHighRate,
            lineTension: 0.2,
            borderColor: "red",
            borderWidth: 1
          }]
        },
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true
              }
            }]
          }
        }
      })
    });
  }
}

export interface Curries {

  firstCur: string;
  secondCur: string;

}

export interface ChartData {

  dateTime: string;
  highRate: string;

}

