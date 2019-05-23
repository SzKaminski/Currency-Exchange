import { Component, OnInit } from '@angular/core';
import {Chart} from 'chart.js';

@Component({
  selector: 'app-chart',
  templateUrl: './chart.component.html',
  styleUrls: ['./chart.component.css']
})
export class ChartComponent implements OnInit {

  constructor() { }

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
}
