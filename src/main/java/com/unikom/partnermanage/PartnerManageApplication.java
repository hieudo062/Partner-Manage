package com.unikom.partnermanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class PartnerManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PartnerManageApplication.class, args);
    }

}
