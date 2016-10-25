package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.io.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrew Shubin on 10/19/16.
 */
@RestController
public class HelloController {

    private int count = 0;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting() throws IOException {
        // ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();

        if (FileUtils.readFileToString(new File("./message.txt")).equals("")) {
            return new Greeting(count, "File Empty");
        }
        String message = FileUtils.readFileToString(new File("./message.txt"));

        // Deserialize JSON to greeter object
        Greeting greeting = mapper.readValue(message, Greeting.class);

        return greeting;
    }

    @RequestMapping(value = "/updateGreeting", method = RequestMethod.PUT)
    public Greeting updateGreeting(@RequestBody String newMessage) throws IOException {
        // ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();

        String message = FileUtils.readFileToString(new File("./message.txt"));

        // Deserialize JSON to greeting object
        Greeting greeting = mapper.readValue(message, Greeting.class);

        // Update message
        greeting.setContent(newMessage);

        // Serialize greeting object to JSON
        mapper.writeValue(new File("message.txt"), greeting);

        return greeting;
    }

    @RequestMapping(value = "/deleteGreeting", method = RequestMethod.DELETE)
    public void deleteGreeting(@RequestBody int id) throws IOException {
        // ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();
        String message = FileUtils.readFileToString(new File("./message.txt"));

        // Deserialize JSON to greeter object
        Greeting greeting = mapper.readValue(message, Greeting.class);
        if (greeting.getId() == id) {
            FileUtils.writeStringToFile(new File("./message.txt"), "");
        }
    }

    @RequestMapping(value = "/createGreeting", method = RequestMethod.POST)
    public Greeting createGreeting(@RequestBody String name) throws IOException {
        // ObjectMapper provides functionality for reading and writing JSON
        ObjectMapper mapper = new ObjectMapper();

        // Create message
        Greeting greeting = new Greeting(++count, name);

        // Serialize greeting object to JSON
        mapper.writeValue(new File("./message.txt"), greeting);

        return greeting;
    }

//    @RequestMapping("/greeting2")
//    public String greeting2(@RequestParam(value="name", defaultValue = "World") String name) {
//        return "Hello " + name;
//    }
//
//    @RequestMapping(value="/getHighestGreeting", method= RequestMethod.POST)
//    public Greeting getHighestGreeting(@RequestBody List<Greeting> list) {
//        Greeting highestGreeting = new Greeting(0, "");
//        for (Greeting greet : list) {
//            if (greet.getId() >= highestGreeting.getId()) {
//                highestGreeting = greet;
//            }
//        }
//        return highestGreeting;
//    }

}
