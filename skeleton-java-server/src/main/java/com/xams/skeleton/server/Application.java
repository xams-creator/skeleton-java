package com.xams.skeleton.server;

import com.xams.skeleton.common.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


    @Autowired
    private OrderService service;

    @PostConstruct
    void init() {
        System.out.println("============================");
        System.out.println(service.view());
        System.out.println("============================");
    }

    @GetMapping("/order/{id}")
    public void order(@PathVariable("id") Long id) {
        System.out.println("============================");
        System.out.println(id);
        System.out.println("============================");
    }

}

