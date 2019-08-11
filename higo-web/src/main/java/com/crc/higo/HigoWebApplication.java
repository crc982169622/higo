package com.crc.higo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HigoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HigoWebApplication.class, args);
    }
}
