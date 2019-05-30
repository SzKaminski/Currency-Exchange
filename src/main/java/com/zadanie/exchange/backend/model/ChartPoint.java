package com.zadanie.exchange.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChartPoint {

    private String dateTime;
    private Object highRate;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Object getHighRate() {
        return highRate;
    }

    public void setHighRate(Object highRate) {
        this.highRate = highRate;
    }
}
