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

import com.cmymesh.service.demo.cars.commons.controller.PaginationParameters;
import com.cmymesh.service.demo.cars.commons.exceptions.InternalServerErrorException;
import com.cmymesh.service.demo.cars.commons.exceptions.NotFoundException;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.service.CarsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsController implements CarsApi {

  private final CarsService carService;

  @Override
  public ResponseEntity<Car> addCar(@Valid Car body) {

    Optional<Car> pojo = carService.addCar(body);
    if (pojo.isPresent()) {
      return new ResponseEntity<>(pojo.get(), HttpStatus.CREATED);
    }
    throw new InternalServerErrorException("Unexpected error while creating entity");
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
  public ResponseEntity<List<CarSummary>> listCars(@Valid List<String> fields,
      @Min(1) @Max(1000) @Valid Integer limit, @Size(min = 1, max = 512) @Valid String page,
      @Valid String sortOrder, @Valid String sortBy) {

    PaginationParameters pagination = new PaginationParameters(ControllerUtils.getLimit(limit),
        ControllerUtils.getPage(page), ControllerUtils.getSortOrder(sortOrder),
        ControllerUtils.getSortBy(sortBy));

    List<CarSummary> list = carService.listCars(pagination);
    if (list != null) {
      return new ResponseEntity<>(list, HttpStatus.OK);
    }
    throw new InternalServerErrorException("Something happened , our list of cars is null yaiks!");
  }

  @Override
  public ResponseEntity<Car> updateCar(@Valid Car body) {

    Optional<Car> pojo = carService.updateCar(body);

    if (pojo.isPresent()) {
      return new ResponseEntity<>(pojo.get(), HttpStatus.CREATED);
    }
    throw new NotFoundException();
  }

}
