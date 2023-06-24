package com.foobar.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// how to add some kind of restriction on who can access these endpoints?

@RestController
public class WebRestController {
    @Autowired
    BadDAO dao;
    @GetMapping("/board/{id}")
    public String getBoard(@PathVariable int id) {
        String fen = dao.getBoard(id);
        return fen;
    }

    @PutMapping("/board/{id}")
    public void setBoard(@PathVariable int id, @RequestBody String val) {
        dao.setBoard(id, val);
    }
}
