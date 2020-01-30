package com.gpu.epidemic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ServletComponentScan(value = {"com.gpu.epidemic.filter"})
public class EpidApplication {
    public static void main(String[] args) {
        SpringApplication.run(EpidApplication.class, args);
    }
}
