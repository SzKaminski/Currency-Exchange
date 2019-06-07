package com.zadanie.exchange.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zadanie.exchange.backend.model.ChartPoint;
import com.zadanie.exchange.backend.model.Currencies;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ConnectionService {

    public Map getValuesMap() throws IOException {
        String text = getTextFromURL(
                new URL("https://openexchangerates.org/api/latest.json?app_id=2885673c4858427abcacbe349a582fbc&prettyprint=0")
        );

        Map<String, Object> jsonFileAsMap = new ObjectMapper().readValue(text, new TypeReference<Map<String, Object>>() {
        });

        Map<String, Object> rates = (Map<String, Object>) jsonFileAsMap.get("rates");
        return rates;
    }

    private static String getTextFromURL(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        try (InputStream inputStream = connection.getInputStream()) {
            Scanner sc = new Scanner(inputStream);
            return sc.nextLine();
        }
    }

    private static String getStringByCurrencies(String firstCurrency, String secondCurrency, boolean isForChart) {
        StringBuilder sb = new StringBuilder()
                .append("https://www.alphavantage.co/query?function=")
                .append("CURRENCY_EXCHANGE_RATE")
                .append("&from_currency=")
                .append(firstCurrency)
                .append("&to_currency=")
                .append(secondCurrency)
                .append("&apikey=KVIBWDX90RUCR3PW");

        if (!isForChart) {
            return sb.toString();
        } else {
            sb.replace(43, 123, "")
                    .append("FX_DAILY")
                    .append("&from_symbol=")
                    .append(firstCurrency)
                    .append("&to_symbol=")
                    .append(secondCurrency)
                    .append("&outputsize=full")
                    .append("&apikey=KVIBWDX90RUCR3PW");
            return sb.toString();
        }
    }

    public String getRealtimeCurrencyExchangeRate(Currencies currencies, String objFromJson, String key) {
        String exchange_rateString = null;
        try {
            String firstCurrency = currencies.getFirstCur();
            String secondCurrency = currencies.getSecondCur();
            URL obj = new URL(getStringByCurrencies(firstCurrency, secondCurrency, false));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            JSONObject obj_JSONObject = getJsonObject(obj, con);
            JSONObject realtime_currency_exchange_rate = obj_JSONObject.getJSONObject(objFromJson);

            exchange_rateString = realtime_currency_exchange_rate.getString(key);
            return exchange_rateString;

        } catch (Exception e) {
           e.printStackTrace();
        }
        return exchange_rateString;
    }

    private JSONObject getJsonObject(URL obj, HttpURLConnection con) throws IOException {

        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return new JSONObject(response.toString());
    }

    public String getJson() throws IOException {
        return getTextFromURL(new URL("http://localhost:4200/"));
    }

    public List<ChartPoint> getHistoricalChart(Currencies currencies) {

        try {
            String firstCurrency = currencies.getFirstCur();
            String secondCurrency = currencies.getSecondCur();
            URL obj = new URL(getStringByCurrencies(firstCurrency, secondCurrency, true));
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            JSONObject obj_JSONObject = getJsonObject(obj, con);
            JSONObject realtime_currency_exchange_rate = obj_JSONObject.getJSONObject("Time Series FX (Daily)");

            List<ChartPoint> chartpoints = new ArrayList<>();
            realtime_currency_exchange_rate.toMap().forEach((x, y) -> {
                ChartPoint cp = new ChartPoint();
                cp.setDateTime(x);
                String highY = y.toString().replaceAll("[^\\d.]+|\\.(?!\\d)", "").substring(1,6);
                cp.setHighRate(highY);
                chartpoints.add(cp);
            });

            chartpoints.sort((o1, o2) -> {
                Date formatO1;
                Date formatO2;
                try {
                    formatO1 = new SimpleDateFormat("yyyy-MM-dd").parse(o1.getDateTime());
                    formatO2 = new SimpleDateFormat("yyyy-MM-dd").parse(o2.getDateTime());

                    if (formatO1.before(formatO2)) {
                        return -1;
                    } else if (formatO1.after(formatO2)) {
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            });

            return chartpoints;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
