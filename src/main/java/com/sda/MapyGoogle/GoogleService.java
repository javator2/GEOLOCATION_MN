package com.sda.MapyGoogle;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class GoogleService {
        private String finalUrl;

        public String getFinalUrl() {
            return finalUrl;
        }

        GoogleService(String url, String localization, String ApiKey) {
            String encodedLocalization = null;
            try {
                encodedLocalization = URLEncoder.encode(localization,"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            this.finalUrl = url+encodedLocalization+ApiKey;


            try {

                JSONObject json = new JSONObject(IOUtils.toString(new URL(finalUrl), Charset.forName("UTF-8")));

                Place place = new Place();

                place.setName(localization);
                place.setLan((Double) json.getJSONArray("results").getJSONObject(Integer.parseInt("0")).getJSONObject("geometry").getJSONObject("location").get("lat"));
                place.setLng((Double) json.getJSONArray("results").getJSONObject(Integer.parseInt("0")).getJSONObject("geometry").getJSONObject("location").get("lng"));
                System.out.println(place.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }




        }


        @Override
        public String toString() {
            return finalUrl;
        }
    }
