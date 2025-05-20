package com.example;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API {
    public static void getData(String endpoint) throws Exception {
        /*endpoint is a url (string) that you get from an API website*/
        URL url = new URL(endpoint);
        InputStream is = (InputStream) url.openStream();
        FileInputStream imageInFile = new FileInputStream(is.toString());
        byte imageData[] = new byte[2048];
        imageInFile.read(imageData);
        System.out.println(imageInFile.toString());
    }
}

