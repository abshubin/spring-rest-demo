package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Andrew Shubin on 10/19/16.
 */
@RestController
public class HelloController {

    private int count = 0;

    @RequestMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(count++, "World");
    }

    @RequestMapping("/greeting2")
    public String greeting2(@RequestParam(value="name", defaultValue = "World") String name) {
        return "Hello " + name;
    }


}
