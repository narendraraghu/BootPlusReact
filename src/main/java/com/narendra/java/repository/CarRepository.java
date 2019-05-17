package com.narendra.java.repository;

import com.narendra.java.pojo.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

    //  List<Car> findByBrand(String brand);
    // Fetch cars by color
    //  List<Car> findByColor(String color);
    // Fetch cars by year
    List<Car> findByYear(int year);

    // Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandOrderByYearAsc(String brand);

    // Fetch cars by brand using SQL
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrandQuesry(String brand);

    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndsWith(String brand);

    @Async
    Future<Car> findProductById(int id);

    // Fetch cars by brand
    List<Car> findByBrand(@Param("brand") String brand);

    // Fetch cars by color
    List<Car> findByColor(@Param("color") String color);


}
