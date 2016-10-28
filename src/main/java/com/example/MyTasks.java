package com.example;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Andrew Shubin on 10/27/16.
 */

@Component
public class MyTasks {

    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "0/10 * * * * *")
    public void periodicHam() {
        putThenGet("Ham");
    }

    @Scheduled(cron = "5/10 * * * * *")
    public void periodicSpam() {
        putThenGet("Spam");
    }

    private void putThenGet(String message) {
        String get = "http://localhost:8080/greeting";
        String put = "http://localhost:8080/updateGreeting";
        restTemplate.put(put, message, Greeting.class);
        Greeting g = restTemplate.getForObject(get, Greeting.class);
        System.out.println(g.getContent());
    }

}
