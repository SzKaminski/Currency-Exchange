package com.zadanie.exchange.backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Service
public class ConnectionService {

    public Map getValuesMap() throws IOException {

        /*String text = getTextFromUrl(
                //new URL("https://openexchangerates.org/api/latest.json?app_id=2885673c4858427abcacbe349a582fbc&prettyprint=0")
        );*/

        String ex = getTextFromString("{\"disclaimer\":\"Usage subject to terms: https://openexchangerates.org/terms\",\"license\":\"https://openexchangerates.org/license\",\"timestamp\":1558533600,\"base\":\"USD\",\"rates\":{\"AED\":3.67295,\"AFN\":80.199694,\"ALL\":109.59,\"AMD\":479.238706,\"ANG\":1.875098,\"AOA\":328.8665,\"ARS\":44.57,\"AUD\":1.452995,\"AWG\":1.799996,\"AZN\":1.7025,\"BAM\":1.751051,\"BBD\":2,\"BDT\":84.5,\"BGN\":1.75215,\"BHD\":0.376977,\"BIF\":1844,\"BMD\":1,\"BND\":1.350702,\"BOB\":6.910441,\"BRL\":4.017016,\"BSD\":1,\"BTC\":0.000127169095,\"BTN\":69.727034,\"BWP\":10.752981,\"BYN\":2.074953,\"BZD\":2.015666,\"CAD\":1.33877,\"CDF\":1650,\"CHF\":1.008766,\"CLF\":0.024276,\"CLP\":695,\"CNH\":6.934227,\"CNY\":6.90515,\"COP\":3335.52,\"CRC\":585.59695,\"CUC\":1,\"CUP\":25.75,\"CVE\":99.2605,\"CZK\":23.119338,\"DJF\":178.05,\"DKK\":6.689912,\"DOP\":50.685,\"DZD\":119.72,\"EGP\":16.9394,\"ERN\":14.997381,\"ETB\":28.855053,\"EUR\":0.895845,\"FJD\":2.164594,\"FKP\":0.791474,\"GBP\":0.791474,\"GEL\":2.755,\"GGP\":0.791474,\"GHS\":5.2,\"GIP\":0.791474,\"GMD\":49.575,\"GNF\":9225,\"GTQ\":7.6747,\"GYD\":209.350004,\"HKD\":7.84986,\"HNL\":24.456393,\"HRK\":6.654184,\"HTG\":89.610832,\"HUF\":292.47039,\"IDR\":14515.052259,\"ILS\":3.611489,\"IMP\":0.791474,\"INR\":69.73,\"IQD\":1193.258564,\"IRR\":42105,\"ISK\":124.09011,\"JEP\":0.791474,\"JMD\":134.520501,\"JOD\":0.708503,\"JPY\":110.36725,\"KES\":101.31,\"KGS\":68.708413,\"KHR\":4056.5,\"KMF\":441.323099,\"KPW\":900,\"KRW\":1190.39,\"KWD\":0.3045,\"KYD\":0.833358,\"KZT\":378.87,\"LAK\":8640,\"LBP\":1507,\"LKR\":176.56,\"LRD\":181.450066,\"LSL\":14.36,\"LYD\":1.402053,\"MAD\":9.685203,\"MDL\":17.980851,\"MGA\":3683.935605,\"MKD\":55.109995,\"MMK\":1538.609463,\"MNT\":2453.75,\"MOP\":8.08594,\"MRO\":357,\"MRU\":36.72,\"MUR\":35.430098,\"MVR\":15.400026,\"MWK\":717.579445,\"MXN\":18.96229,\"MYR\":4.189975,\"MZN\":63.649524,\"NAD\":14.36,\"NGN\":360.49,\"NIO\":32.898587,\"NOK\":8.738985,\"NPR\":111.564405,\"NZD\":1.538959,\"OMR\":0.385001,\"PAB\":1,\"PEN\":3.345206,\"PGK\":3.37485,\"PHP\":52.463,\"PKR\":152.375,\"PLN\":3.85708,\"PYG\":6287.53338,\"QAR\":3.6414,\"RON\":4.268115,\"RSD\":105.66957,\"RUB\":64.2605,\"RWF\":907.024119,\"SAR\":3.74975,\"SBD\":8.205546,\"SCR\":13.660012,\"SDG\":45.112074,\"SEK\":9.635795,\"SGD\":1.378798,\"SHP\":0.791474,\"SLL\":8390,\"SOS\":578.466944,\"SRD\":7.458,\"SSP\":130.2634,\"STD\":21050.59961,\"STN\":21.975,\"SVC\":8.749674,\"SYP\":515.023341,\"SZL\":14.364135,\"THB\":31.948887,\"TJS\":9.43477,\"TMT\":3.499986,\"TND\":3.005486,\"TOP\":2.296572,\"TRY\":6.099362,\"TTD\":6.77455,\"TWD\":31.473135,\"TZS\":2300.2,\"UAH\":26.364,\"UGX\":3761.889857,\"USD\":1,\"UYU\":35.292846,\"UZS\":8458.178655,\"VEF\":248487.642241,\"VES\":5533.461476,\"VND\":23383.90623,\"VUV\":112.043789,\"WST\":2.621728,\"XAF\":587.635676,\"XAG\":0.06917317,\"XAU\":0.00078468,\"XCD\":2.70265,\"XDR\":0.721556,\"XOF\":587.635676,\"XPD\":0.00076426,\"XPF\":106.902722,\"XPT\":0.0012384,\"YER\":250.300682,\"ZAR\":14.363999,\"ZMW\":13.804,\"ZWL\":322.355011}}");

        Map<String, Object> jsonFileAsMap = new ObjectMapper().readValue(ex, new TypeReference<Map<String, Object>>() {
        });

        return (Map<String, Object>) jsonFileAsMap.get("rates");
    }

    public Set getValuesList() throws IOException {

        String ex = getTextFromString("{\"disclaimer\":\"Usage subject to terms: https://openexchangerates.org/terms\",\"license\":\"https://openexchangerates.org/license\",\"timestamp\":1558533600,\"base\":\"USD\",\"rates\":{\"AED\":3.67295,\"AFN\":80.199694,\"ALL\":109.59,\"AMD\":479.238706,\"ANG\":1.875098,\"AOA\":328.8665,\"ARS\":44.57,\"AUD\":1.452995,\"AWG\":1.799996,\"AZN\":1.7025,\"BAM\":1.751051,\"BBD\":2,\"BDT\":84.5,\"BGN\":1.75215,\"BHD\":0.376977,\"BIF\":1844,\"BMD\":1,\"BND\":1.350702,\"BOB\":6.910441,\"BRL\":4.017016,\"BSD\":1,\"BTC\":0.000127169095,\"BTN\":69.727034,\"BWP\":10.752981,\"BYN\":2.074953,\"BZD\":2.015666,\"CAD\":1.33877,\"CDF\":1650,\"CHF\":1.008766,\"CLF\":0.024276,\"CLP\":695,\"CNH\":6.934227,\"CNY\":6.90515,\"COP\":3335.52,\"CRC\":585.59695,\"CUC\":1,\"CUP\":25.75,\"CVE\":99.2605,\"CZK\":23.119338,\"DJF\":178.05,\"DKK\":6.689912,\"DOP\":50.685,\"DZD\":119.72,\"EGP\":16.9394,\"ERN\":14.997381,\"ETB\":28.855053,\"EUR\":0.895845,\"FJD\":2.164594,\"FKP\":0.791474,\"GBP\":0.791474,\"GEL\":2.755,\"GGP\":0.791474,\"GHS\":5.2,\"GIP\":0.791474,\"GMD\":49.575,\"GNF\":9225,\"GTQ\":7.6747,\"GYD\":209.350004,\"HKD\":7.84986,\"HNL\":24.456393,\"HRK\":6.654184,\"HTG\":89.610832,\"HUF\":292.47039,\"IDR\":14515.052259,\"ILS\":3.611489,\"IMP\":0.791474,\"INR\":69.73,\"IQD\":1193.258564,\"IRR\":42105,\"ISK\":124.09011,\"JEP\":0.791474,\"JMD\":134.520501,\"JOD\":0.708503,\"JPY\":110.36725,\"KES\":101.31,\"KGS\":68.708413,\"KHR\":4056.5,\"KMF\":441.323099,\"KPW\":900,\"KRW\":1190.39,\"KWD\":0.3045,\"KYD\":0.833358,\"KZT\":378.87,\"LAK\":8640,\"LBP\":1507,\"LKR\":176.56,\"LRD\":181.450066,\"LSL\":14.36,\"LYD\":1.402053,\"MAD\":9.685203,\"MDL\":17.980851,\"MGA\":3683.935605,\"MKD\":55.109995,\"MMK\":1538.609463,\"MNT\":2453.75,\"MOP\":8.08594,\"MRO\":357,\"MRU\":36.72,\"MUR\":35.430098,\"MVR\":15.400026,\"MWK\":717.579445,\"MXN\":18.96229,\"MYR\":4.189975,\"MZN\":63.649524,\"NAD\":14.36,\"NGN\":360.49,\"NIO\":32.898587,\"NOK\":8.738985,\"NPR\":111.564405,\"NZD\":1.538959,\"OMR\":0.385001,\"PAB\":1,\"PEN\":3.345206,\"PGK\":3.37485,\"PHP\":52.463,\"PKR\":152.375,\"PLN\":3.85708,\"PYG\":6287.53338,\"QAR\":3.6414,\"RON\":4.268115,\"RSD\":105.66957,\"RUB\":64.2605,\"RWF\":907.024119,\"SAR\":3.74975,\"SBD\":8.205546,\"SCR\":13.660012,\"SDG\":45.112074,\"SEK\":9.635795,\"SGD\":1.378798,\"SHP\":0.791474,\"SLL\":8390,\"SOS\":578.466944,\"SRD\":7.458,\"SSP\":130.2634,\"STD\":21050.59961,\"STN\":21.975,\"SVC\":8.749674,\"SYP\":515.023341,\"SZL\":14.364135,\"THB\":31.948887,\"TJS\":9.43477,\"TMT\":3.499986,\"TND\":3.005486,\"TOP\":2.296572,\"TRY\":6.099362,\"TTD\":6.77455,\"TWD\":31.473135,\"TZS\":2300.2,\"UAH\":26.364,\"UGX\":3761.889857,\"USD\":1,\"UYU\":35.292846,\"UZS\":8458.178655,\"VEF\":248487.642241,\"VES\":5533.461476,\"VND\":23383.90623,\"VUV\":112.043789,\"WST\":2.621728,\"XAF\":587.635676,\"XAG\":0.06917317,\"XAU\":0.00078468,\"XCD\":2.70265,\"XDR\":0.721556,\"XOF\":587.635676,\"XPD\":0.00076426,\"XPF\":106.902722,\"XPT\":0.0012384,\"YER\":250.300682,\"ZAR\":14.363999,\"ZMW\":13.804,\"ZWL\":322.355011}}");

        Map<String, Object> jsonFileAsMap = new ObjectMapper().readValue(ex, new TypeReference<Map<String, Object>>() {
        });


        Set set = getValuesMap().keySet();
        return set;
    }

    private static String getTextFromUrl(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        try (InputStream is = connection.getInputStream()) {
            Scanner scanner = new Scanner(is);
            return scanner.nextLine();
        }
    }

    private static String getTextFromString(String str) throws IOException {

        Scanner scanner = new Scanner(str);
        return scanner.nextLine();
    }


}
