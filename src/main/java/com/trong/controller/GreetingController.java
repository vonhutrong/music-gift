package com.trong.controller;

import com.trong.Greeting;
import com.trong.HelloMessage;
import com.trong.dto.PlayerInformation;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @RequestMapping("demo-thymeleaf")
    public String demoThymeleaf() {
        return "demo-thymeleaf";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("playerInformation", new PlayerInformation());
        return "home";
    }
}
