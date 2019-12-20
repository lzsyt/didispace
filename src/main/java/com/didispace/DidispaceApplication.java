package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.didispace.mapper")
@SpringBootApplication(scanBasePackages = "com.didispace")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DidispaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DidispaceApplication.class, args);
    }

}
