import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js';
import {ExchangeService} from "../shared/exchange/exchange.service";
import {Curries} from "../exchange/exchange.component";

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {
  private curries: Curries;

  constructor(public exchangeService: ExchangeService) { }

  ngOnInit() {
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
  public dataResponse: Curries;

  setFirstCurrency(value: string) {
    this.firstCurrency = value;

  }

  setSecondCurrency(value: string) {
    this.secondCurrency = value;
  }


  getChartData() {
    this.curries = {
      firstCur: this.firstCurrency,
      secondCur: this.secondCurrency,
    };
    this.exchangeService.postJSON(this.curries).subscribe(data => {
      console.log(data)
      this.dataResponse = data;
      console.log(this.dataResponse);
    });
  }
}
