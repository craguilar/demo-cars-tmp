package com.cmymesh.service.demo.cars.service;

import java.util.Optional;
import java.util.stream.Stream;

import com.cmymesh.service.demo.cars.commons.controller.PaginationParameters;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;

public interface CarsService {

  // add , get , list and update

  Optional<Car> addCar(Car car);

  Optional<Car> getCar(String carId);

  Stream<CarSummary> listCars(PaginationParameters pagination);

  Optional<Car> updateCar(Car car);
}
