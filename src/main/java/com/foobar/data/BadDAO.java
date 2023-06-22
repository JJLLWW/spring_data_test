package com.foobar.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BadDAO implements InitializingBean {
    @Autowired
    JdbcTemplate dbTemplate;
    @Override
    public void afterPropertiesSet() throws Exception {
        dbTemplate.execute("DROP TABLE state IF EXISTS;");
        dbTemplate.execute("CREATE TABLE state (text VARCHAR(255));");
        dbTemplate.execute("INSERT INTO state (text) VALUES ('ABCDEF');");
    }
    public String doQuery() {
        String val = dbTemplate.queryForObject("SELECT text FROM state", String.class);
        return val;
    }
}
