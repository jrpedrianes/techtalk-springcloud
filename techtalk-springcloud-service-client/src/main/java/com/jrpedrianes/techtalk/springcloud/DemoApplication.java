package com.jrpedrianes.techtalk.springcloud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner runner(DiscoveryClient dc) {
        return args -> {
            System.out.println("\n ****************** \n");
            dc.getInstances("techtalk-springcloud-service")
                    .forEach(si -> System.out.println(String.format("%s %s:%s", si.getServiceId(), si.getHost(), si.getPort())));
            System.out.println("\n ****************** \n");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}