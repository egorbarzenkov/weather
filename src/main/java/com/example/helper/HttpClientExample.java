package com.example.helper;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;


@Service
public class HttpClientExample {


    public Double sendGet(String lat, String lon) throws Exception {
         CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=";
        String two = "&lon=";
        String three = "&APPID=0bc9fcacaff672d115bfd1a4d591b3b4";
        HttpGet request = new HttpGet(url+lat+two+lon+three);

        System.out.println(url+lat+two+lon+three);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
               return setWeather(result);
            }
        }
        finally {
            httpClient.close();
        }
        return null;
    }

    private Double setWeather(String json) throws ParseException {
        Object obj = new JSONParser().parse(json);
        JSONObject jo = (JSONObject) obj;
        System.out.println(json);

        JSONObject object = (JSONObject) jo.get("main");
        Double temp = (Double) object.get("temp");

        return temp-273;
    }
//Todo запилить по названию города и без лишних преобразований
    public Double sendGetMetric(String name) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "https://api.openweathermap.org/data/2.5/find?q=";
        String two = "&units=metric&APPID=0bc9fcacaff672d115bfd1a4d591b3b4";
        HttpGet request = new HttpGet(url+name+two);

        System.out.println(url+name+two);

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                Object obj = new JSONParser().parse(result);
                JSONObject jo = (JSONObject) obj;
                JSONArray list = (JSONArray) jo.get("list");
                JSONObject object = (JSONObject) list.get(0);
                JSONObject main = (JSONObject) object.get("main");
                Double temp = ((Number) main.get("temp")).doubleValue();
                return temp;
            }
        }
        finally {
            httpClient.close();
        }
        return null;
    }
}