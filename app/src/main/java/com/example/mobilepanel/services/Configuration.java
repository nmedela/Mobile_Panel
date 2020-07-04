package com.example.mobilepanel.services;

public class Configuration {
    private static String url = "http://192.168.0.99";
    private static String port = "4000";
    private static Configuration configuration;

    private static Configuration getConfiguration(){
       if(configuration==null) {
           configuration = new Configuration();
       }
       return configuration;
    }

    public Configuration(){

    }

    public static String getUrl(){
        return url;
    }

    public static String getPort() {
        return port;
    }
}
