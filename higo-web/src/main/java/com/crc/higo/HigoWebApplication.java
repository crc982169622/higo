package com.crc.higo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.crc.higo.mapper")
public class HigoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HigoWebApplication.class, args);
    }
}
