package com.cmymesh.service.demo.cars.service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmymesh.service.demo.cars.commons.util.DateUtils;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.repository.CarsRepository;

@Service
public class CarsServiceImpl implements CarsService {

  @Autowired
  CarsRepository carsRepository;

  @Override
  public Optional<Car> addCar(Car car) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Optional<Car> getCar(String carId) {
    Optional<com.cmymesh.service.demo.cars.model.entity.Car> entity = carsRepository.findById(carId);

    ModelMapper modelMapper = new ModelMapper();

    Converter<Date, OffsetDateTime> toOffsetDateTime = new Converter<Date, OffsetDateTime>() {
      @Override
      public OffsetDateTime convert(MappingContext<Date, OffsetDateTime> context) {
        return DateUtils.dateToOffsetDateTime(context.getSource());
      }
    };

    modelMapper.addConverter(toOffsetDateTime);

    if (entity.isPresent()) {
      Car pojo = modelMapper.map(entity.get(), Car.class);
      return Optional.of(pojo);
    }
    return Optional.empty();

  }

  @Override
  public List<CarSummary> listCars() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Optional<Car> updateCar(Car car) {
    throw new UnsupportedOperationException();
  }

}
