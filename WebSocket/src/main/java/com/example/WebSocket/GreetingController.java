package com.example.WebSocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greetings greet(Message message) throws InterruptedException {
        Thread.sleep(2000);
        return new Greetings("Hello, " +
                HtmlUtils.htmlEscape(message.getName()));
    }
}
