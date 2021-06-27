package com.cmymesh.service.demo.cars.service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmymesh.service.demo.cars.commons.controller.PaginationParameters;
import com.cmymesh.service.demo.cars.commons.util.DateUtils;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.repository.CarsRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * I was experimenting on Isolation.SERIALIZABLE with H2 and after some tests it seems there is no
 * decent support for SERIALIZABLE level , the testing was :
 * <ol>
 * <li/>At t0 throw a bunch of threads writing a new car addCar.
 * <li/>Each of these threads will execute a read first then if the car DOES NOT exist , will
 * persist it to theDB
 * <li/>If you run this multiple times you will notice for this experiment there are more than one
 * Car [{}] doesn't exist creating one log printed.
 * </ol>
 * 
 * What this means is: I can trust in data base or framework promises for transaction isolations (or
 * , I don't know how effectively use them). For now I am just happy with the fact that "addCar"
 * will be idempotent based on Primary Key constraings (a data base guarantee).
 * 
 * @author carlos
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsServiceImpl implements CarsService {

  private final CarsRepository carsRepository;
  private final ModelMapper entityToPojoModelMapper;
  private final ModelMapper pojoToEntityModelMapper;

  @Override
  @Transactional
  public Optional<Car> addCar(@NonNull Car car) {

    Optional<Car> existingCar = getCar(car.getMake());
    if (existingCar.isPresent()) {
      return existingCar;
    }

    log.info("Car [{}] doesn't exist creating one", car.getMake());
    com.cmymesh.service.demo.cars.model.entity.Car entity = pojoToEntityModelMapper().map(car,
        com.cmymesh.service.demo.cars.model.entity.Car.class);
    entity.setId(car.getMake());
    entity.setTimeCreated(new Date());
    entity.setTimeUpdated(new Date());

    carsRepository.saveAndFlush(entity);
    return Optional.of(car);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Car> getCar(String carId) {
    Optional<com.cmymesh.service.demo.cars.model.entity.Car> entity = carsRepository
        .findById(carId);
    if (entity.isPresent()) {
      Car pojo = entityToPojoModelMapper().map(entity.get(), Car.class);
      return Optional.of(pojo);
    }
    return Optional.empty();

  }

  @Override
  @Transactional(readOnly = true)
  public List<CarSummary> listCars(PaginationParameters pagination) {

    Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getLimit(),
        Sort.by(Sort.Direction.valueOf(pagination.getSortOrder()), pagination.getSortBy()));

    Page<com.cmymesh.service.demo.cars.model.entity.Car> cars = carsRepository.findAll(pageable);

    return cars.map(this::getCarSummaryByCar).toList();

  }

  @Override
  public Optional<Car> updateCar(Car car) {
    Optional<com.cmymesh.service.demo.cars.model.entity.Car> entity = carsRepository
        .findById(car.getPlate());
    if (!entity.isPresent()) {
      return Optional.empty();
    }
    carsRepository.save(
        pojoToEntityModelMapper().map(car, com.cmymesh.service.demo.cars.model.entity.Car.class));
    return Optional.of(car);
  }

  private CarSummary getCarSummaryByCar(com.cmymesh.service.demo.cars.model.entity.Car entity) {
    CarSummary summary = new CarSummary();
    summary.setPlate(entity.getId());
    summary.setModel(entity.getModel());
    summary.setMake(entity.getMake());
    summary.setDescription(entity.getDescription());
    summary.setTypeOfUse(entity.getTypeOfUse());
    return summary;
  }

  public ModelMapper entityToPojoModelMapper() {

    TypeMap<com.cmymesh.service.demo.cars.model.entity.Car, Car> typeMap = entityToPojoModelMapper
        .createTypeMap(com.cmymesh.service.demo.cars.model.entity.Car.class, Car.class);

    Converter<Date, OffsetDateTime> toOffsetDateTime = (
        MappingContext<Date, OffsetDateTime> context) -> DateUtils
            .dateToOffsetDateTime(context.getSource());

    entityToPojoModelMapper.addConverter(toOffsetDateTime);
    typeMap.addMappings(mapper -> {
      mapper.map(com.cmymesh.service.demo.cars.model.entity.Car::getId, Car::setPlate);
    });
    return entityToPojoModelMapper;
  }

  public ModelMapper pojoToEntityModelMapper() {

    TypeMap<Car, com.cmymesh.service.demo.cars.model.entity.Car> typeMap = pojoToEntityModelMapper
        .createTypeMap(Car.class, com.cmymesh.service.demo.cars.model.entity.Car.class);

    Converter<Date, OffsetDateTime> toOffsetDateTime = (
        MappingContext<Date, OffsetDateTime> context) -> DateUtils
            .dateToOffsetDateTime(context.getSource());
    pojoToEntityModelMapper.addConverter(toOffsetDateTime);
    typeMap.addMappings(mapper -> {
      mapper.map(Car::getPlate, com.cmymesh.service.demo.cars.model.entity.Car::setId);
    });
    return pojoToEntityModelMapper;
  }

}
