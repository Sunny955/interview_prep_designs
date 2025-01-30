package org.lld.prep;

import org.lld.prep.Streams.StreamTestApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrepApplication {
    public static void main(String[] args) {
        SpringApplication.run(PrepApplication.class, args);
    }
}
