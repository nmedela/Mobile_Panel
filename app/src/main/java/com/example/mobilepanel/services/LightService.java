package com.example.mobilepanel.services;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LightService {
    //    private Configuration configuration = new Configuration();
    private String server = Configuration.getUrl();
    private String port = Configuration.getPort();
    private String url = server + ":" + port + "/light/";

    public LightService() {

    }

    public static LightService lightService;

    public static LightService getLightService() {
        if (lightService == null) {
            lightService = new LightService();
        }
        return lightService;
    }

    public void changeMain() throws IOException {
        new Connection().execute();
    }
}

    class Connection extends AsyncTask<Void, Void, Void> {

        private Exception exception;

        protected Void doInBackground(Void... arg0) {

//            String destination = url + "principal";
            try {
                URL url = new URL("http://192.168.0.99:4000/light/principal");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json; utf-8");
                con.setRequestProperty("Accept", "application/json");
                con.setDoOutput(true);
                String jsonInputString = "";
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(con.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println("Esto respondio " + response.toString());
                }

                con.disconnect();
            } catch (Exception e) {
                System.out.println("Hubo un error " + e);
            }
            return null;
        }
}