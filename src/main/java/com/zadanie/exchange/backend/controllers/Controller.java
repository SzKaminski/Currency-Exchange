package com.zadanie.exchange.backend.controllers;

import com.zadanie.exchange.backend.model.Currencies;
import com.zadanie.exchange.backend.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
/*
    @GetMapping("/exchangeCurrencies")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getCurrencyKeyList() {
        return connectionService.getRealtimeCurrencyExchangeRate();
    }*/

    @GetMapping("/exchangeCurrencies")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getJsonVar() throws IOException {
        return connectionService.getJson();
    }

    @PostMapping("/exchangeCurrencies")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Currencies find(@RequestBody Currencies currencies){
        return currencies;
    }

  /*  @GetMapping("/post")
    @CrossOrigin(origins = "http://localhost:4200")
    public String get(){
        return
    }*/

}

