package com.gpu.epidemic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class EpIdApplication {
    public static void main(String[] args) {
        SpringApplication.run(EpIdApplication.class, args);
    }
}
