package com.foobar.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BadDAO {
    @Autowired
    JdbcTemplate dbTemplate;
    public String getBoard(int id) {
        String query = String.format("SELECT fen FROM boards WHERE id = %d;", id);
        return dbTemplate.queryForObject(query, String.class);
    }
    public void setBoard(int id, String fen) {
        String update = String.format("UPDATE boards SET fen = '%s' WHERE id = %d", fen, id);
        dbTemplate.execute(update);
    }
}
