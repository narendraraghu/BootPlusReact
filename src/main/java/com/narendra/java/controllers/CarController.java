package com.narendra.java.controllers;

import com.narendra.java.pojo.Car;
import com.narendra.java.repository.CarRepository;
import com.narendra.java.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    CarRepository carRepository;



    @Value("${custom.property}")
    private String customProperty;

    @Autowired
    CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public Iterable<Car> getAll() {
        return carRepository.findAll();
    }


    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String hello() {
        return "Hello "+customProperty;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable final int id, @RequestBody Car carDTO) {
        long count = carService.update(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final String brand) {

        List<Car> car =carRepository.findByBrand (brand);

        carService.delete(car.get (0));
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
