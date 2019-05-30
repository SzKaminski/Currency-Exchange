package com.zadanie.exchange.backend.controllers;

import com.zadanie.exchange.backend.model.ChartPoint;
import com.zadanie.exchange.backend.model.Currencies;
import com.zadanie.exchange.backend.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    ConnectionService connectionService;

    @GetMapping("/obj")
    @CrossOrigin(origins = "http://localhost:4200")
    public Map getCurrencyMap() throws IOException {
        return connectionService.getValuesMap();
    }

    @GetMapping("/exchangeCurrencies")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getJsonVar() throws IOException {
        return connectionService.getJson();
    }

    @PostMapping("/exchangeCurrencies")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin(origins = "http://localhost:4200")
    public String findByCurrencies(@RequestBody Currencies currencies){
        return connectionService.getRealtimeCurrencyExchangeRate(currencies,
                "Realtime Currency Exchange Rate",
                "5. Exchange Rate");
    }

    @PostMapping("/historicalChart")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @CrossOrigin(origins = "http://locahost:4200")
    public List<ChartPoint> findByCurrenciesTohistoricalChart(@RequestBody Currencies currencies){
        return connectionService.getHistoricalChart(currencies);
    }
}

