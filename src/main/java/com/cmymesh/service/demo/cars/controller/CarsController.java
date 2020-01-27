package com.cmymesh.service.demo.cars.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.cmymesh.service.demo.cars.commons.exceptions.NotFoundException;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.service.CarsService;

@RestController
public class CarsController implements CarsApi {

  @Autowired
  CarsService carService;

  @Override
  public ResponseEntity<Car> addCar(@Valid Car body) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ResponseEntity<Car> getCar(String carId, @Valid List<String> fields) {

    ControllerUtils.validateMandatoryParameter(carId, "carId");

    Optional<Car> pojo = carService.getCar(carId);
    if (pojo.isPresent()) {
      return new ResponseEntity<>(pojo.get(), HttpStatus.OK);
    }

    throw new NotFoundException();

  }

  @Override
  public ResponseEntity<List<CarSummary>> listCars(@Valid List<String> fields, @Min(1) @Max(1000) @Valid Integer limit,
      @Size(min = 1, max = 512) @Valid String page, @Valid String sortOrder, @Valid String sortBy) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ResponseEntity<Car> updateCar(@Valid Car body) {
    throw new UnsupportedOperationException();
  }

}
