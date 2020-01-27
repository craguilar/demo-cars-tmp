package com.cmymesh.service.demo.cars.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cmymesh.service.demo.cars.model.pojo.Car;

@RestController
public class CarsController implements CarsApi {

  @Override
  public ResponseEntity<Car> addCar(@Valid Car body) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Car> getCar(String carId, @Valid List<String> fields) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Object> listCars(@Valid List<String> fields, @Min(1) @Max(1000) @Valid Integer limit,
      @Size(min = 1, max = 512) @Valid String page, @Valid String sortOrder, @Valid String sortBy) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResponseEntity<Car> updateCar(@Valid Car body) {
    // TODO Auto-generated method stub
    return null;
  }

}
