package com.zadanie.exchange.backend.controllers;

import com.zadanie.exchange.backend.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    ConnectionService connectionService;

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:4200")
    public Map getCurrencyMap() throws IOException {
        return connectionService.getValuesMap();
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:4200")
    public Set getCurrencyKeyList() throws IOException {
        return connectionService.getValuesList();
    }
}

