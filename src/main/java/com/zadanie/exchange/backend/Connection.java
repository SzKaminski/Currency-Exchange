package com.zadanie.exchange.backend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

public class Connection {

    public static void main(String[] args) throws IOException {

        String text = getTextFromUrl(
                new URL("https://openexchangerates.org/api/latest.json?app_id=2885673c4858427abcacbe349a582fbc&prettyprint=0")
        );

        Map<String, Object> jsonFileAsMap = new ObjectMapper().readValue(text, new TypeReference<Map<String, Object>>() {
        });

        Map<String, Object> ratesMap = (Map<String, Object>) jsonFileAsMap.get("rates");
        ratesMap.forEach((k, v) -> System.out.println("Key = " + k + ", Value = " + v));
    }

    private static String getTextFromUrl(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        try (InputStream is = connection.getInputStream()) {
            Scanner scanner = new Scanner(is);
            return scanner.nextLine();
        }
    }

}
