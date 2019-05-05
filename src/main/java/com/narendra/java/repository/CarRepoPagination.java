package com.narendra.java.repository;

import com.narendra.java.pojo.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepoPagination extends PagingAndSortingRepository<Car, Long> {

//    //In case we need results in pagination
//    Method                              Description
//    Iterable<T> findAll(Sort sort)      Returns all entities sorted by the given options
//    Page<T> findAll(Pageable pageable)  Returns all entities according to given paging options

}
