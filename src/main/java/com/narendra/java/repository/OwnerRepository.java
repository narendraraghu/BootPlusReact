package com.narendra.java.repository;

import com.narendra.java.pojo.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long>
{
}