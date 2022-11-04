package com.zyn.zzu.tinytwitter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.zyn.zzu.tinytwitter.dao")
public class TinyTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyTwitterApplication.class, args);
    }

}
