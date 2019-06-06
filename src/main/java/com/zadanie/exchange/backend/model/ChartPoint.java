package com.zadanie.exchange.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ChartPoint {

    private String dateTime;
    private String highRate;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getHighRate() {
        return highRate;
    }

    public void setHighRate(String highRate) {
        this.highRate = highRate;
    }
}
