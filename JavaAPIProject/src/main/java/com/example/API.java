package com.example;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

public class API {
    public static String getData(String endpoint) throws Exception {
        /*endpoint is a url (string) that you get from an API website*/
        String string = "placeholder";
        while (!string.substring(string.length() - 3).equals("jpg")) {
            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader buff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = buff.readLine()) != null) {
                content.append(inputLine);
            }
            buff.close();
            connection.disconnect();
            string = content.substring(content.indexOf("\"h") + 1, content.indexOf("\",\"width")).toString();
        }
        return string;
    }
}

