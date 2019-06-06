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
  private timeValue: string;
  private rateValue: string;

  constructor(public exchangeService: ExchangeService) {
  }

  ngOnInit() {
    this.exchangeService.getMap().subscribe(data => {
      this.currencies = data;
      console.log()
    });


    this.LineChart = new Chart('lineChart', {
      type: 'line',

      data: {
        labels: ["un","de","fi","ned"],
        datasets: [{
          data: [0,1,2,3],
          lineTension: 0.2,
          borderColor: "red",
          borderWidth: 1
        }]
      },
      options: {
        title: {
          text: "line",
          display: true
        },
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


  public firstCurrency: string;
  public secondCurrency: string;
  public rateResponse: Curries;
  public chartData: ChartData;


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

  private chartArray: Array<ChartData>;
  private chartMap = new Map();

  getChartData() {
    this.curries = {
      firstCur: this.firstCurrency,
      secondCur: this.secondCurrency,
    };
    this.exchangeService.postJsonForChart(this.curries).subscribe(data => {
      this.chartArray = JSON.parse(JSON.stringify(data));
      console.log(this.chartArray.push(new class implements ChartData {
        dateTime: string;
        highRate: string;
      }));

      for (let entry of this.chartArray) {
        console.log(entry.highRate);
        this.chartMap.set(entry.dateTime, entry.highRate);
      }
      this.LineChart = new Chart('lineChart', {
        type: 'line',

        data: {
          labels: [this.chartMap.forEach((value: string, key: string)=> key.valueOf())],
          datasets: [{
            data: [this.chartMap.forEach((value: string, key: string)=> value.valueOf())],
            lineTension: 0.2,
            borderColor: "red",
            borderWidth: 1
          }]
        },
        options: {
          title: {
            text: "line",
            display: true
          },
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

