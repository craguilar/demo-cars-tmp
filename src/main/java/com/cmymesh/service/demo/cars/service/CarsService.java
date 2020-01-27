package com.cmymesh.service.demo.cars.service;

import java.util.List;
import java.util.Optional;

import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;

public interface CarsService {

  // add , get , list and update

  Optional<Car> addCar(Car car);

  Optional<Car> getCar(String carId);

  List<CarSummary> listCars();

  Optional<Car> updateCar(Car car);
}
