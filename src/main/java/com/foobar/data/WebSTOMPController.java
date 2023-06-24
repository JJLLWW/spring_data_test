package com.foobar.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSTOMPController {
    @Autowired
    BadDAO dao;
    @MessageMapping("/")
    @SendTo("/topic")
    public String doThing() {
        return "HELLO WORLD";
    }
}
