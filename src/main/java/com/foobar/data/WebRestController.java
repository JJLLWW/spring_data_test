package com.foobar.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebRestController {
    @Autowired
    BadDAO dao;
    @GetMapping("/board/{id}")
    public String getBoard(@PathVariable int id) {
        String fen = dao.getBoard(id);
        return fen;
    }

    // maybe having the data in the request body is a bit nasty, don't know the conventions.
    @PutMapping("/board/{id}")
    public void setBoard(@PathVariable int id, @RequestBody String val) {
        dao.setBoard(id, val);
    }
}
