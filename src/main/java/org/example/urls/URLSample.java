package org.example.urls;
import java.net.MalformedURLException;
import java.net.URL;

public class URLSample {
    public static void main(String[] args) throws MalformedURLException {
        String url = "https://www.google.com";
        useUrl(url);
    }
    static void useUrl(String url_string) throws MalformedURLException {
        URL url = new URL(url_string);
        System.out.println("Hostname is " + url.getHost());
        System.out.println("Port number is " + url.getPort());
    }
}
