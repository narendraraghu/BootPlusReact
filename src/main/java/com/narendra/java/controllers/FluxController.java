package com.narendra.java.controllers;

import com.narendra.java.pojo.Car;
import com.narendra.java.pojo.Owner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


    @RestController
    @RequestMapping("/product")
    public class FluxController {

        Owner owner1 = new Owner("Narendra" , "Raghuwanshi");
        Owner owner2 = new Owner("KT" , "Sinha");

        @GetMapping("/one")
        public Mono<Car> oneProduct() {
            return Mono.just((new Car ("Ford", "Mustang", "Red","ADF-1121",
                    2017, 59000,"Dabba",owner1)));

        }

        @GetMapping("/array")
        public Flux<Car> productsFromArray() {
            return Flux.fromArray(
                    new Car[]{
                            new Car ("Ford", "Mustang", "Red", "ADF-1121",
                                    2017, 59000, "Dabba", owner1),
                            new Car ("Ford", "Mustang", "Red", "ADF-1121",
                                    2017, 59000, "Dabba", owner1)
                    }

            );
        }

    }
