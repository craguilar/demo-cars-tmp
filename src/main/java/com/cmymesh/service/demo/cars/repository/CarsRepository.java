package com.cmymesh.service.demo.cars.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmymesh.service.demo.cars.model.entity.Car;

@Repository
public interface CarsRepository extends JpaRepository<Car, String> {

  Optional<Car> findById(String id);

}