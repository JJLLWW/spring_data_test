package com.foobar.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSTOMPController {
    // recipe for disaster, but proof this can work.
    @Autowired
    BadDAO dao;
    @MessageMapping("/")
    @SendTo("/topic")
    public String doThing() {
        String val = dao.doQuery();
        return val;
    }
}
