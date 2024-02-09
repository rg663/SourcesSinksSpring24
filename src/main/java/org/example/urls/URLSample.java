package org.example.urls;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLSample {
    public static void main(String[] args) throws IOException {
        String url = "https://www.google.com";
        useUrl(url);
    }
    static void useUrl(String url_string) throws IOException {
        URL url = new URL(url_string);
        System.out.println("Hostname is " + url.getHost());
        System.out.println("Port number is " + url.getPort());
        URLConnection connection = url.openConnection();
        connection.getInputStream();
    }
}
