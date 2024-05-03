package com.example.CrudTest.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/threads")
public class ThreadController {

    public String getUrlContent(String urlString) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                }
                reader.close();
            } else {
                System.out.println("Failed to retrieve URL content. Response code: " + responseCode);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return content.toString();
    }
    @PostMapping("/no-thread")
    public String no_thread(){
        List<String> urls = new ArrayList<>();
        urls.add("https://www.facebook.com");
        urls.add("https://www.instagram.com");
        urls.add("https://www.twitter.com");
        urls.add("https://www.tiktok.com");
        urls.add("https://www.umg.edu.gt");
        urls.add("https://www.gmail.com");

        List<String> outputs = new ArrayList<>();
        for (String url: urls){
            outputs.add( getUrlContent(url));
        }
        return outputs.get(0);
    }
    @PostMapping("/with-threads")
    public String withThreads(){
        List<String> urls = new ArrayList<>();
        urls.add("https://www.facebook.com");
        urls.add("https://www.instagram.com");
        urls.add("https://www.twitter.com");
        urls.add("https://www.tiktok.com");
        urls.add("https://www.umg.edu.gt");
        urls.add("https://www.gmail.com");
        ExecutorService executor = Executors.newFixedThreadPool(16);
        List<Future<String>> futures = new ArrayList<>();

        for (String url: urls){
            Future<String> future = executor.submit(() -> {
                // Call the getUrlContent method with the page URL
                return getUrlContent(url);
            });
            futures.add(future);
        }
        executor.shutdown();
        List<String> outputs = new ArrayList<>();
        for (Future<String> future: futures){
            try{
                outputs.add(future.get());
            }
            catch(ExecutionException | InterruptedException ex){
                System.err.println(ex.getMessage());
            }


        }
        return outputs.get(0);
    }
}
