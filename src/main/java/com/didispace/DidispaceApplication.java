package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.didispace.mapper")
@SpringBootApplication
public class DidispaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DidispaceApplication.class, args);
    }

}
