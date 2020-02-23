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
import org.springframework.util.StringUtils;

import com.cmymesh.service.demo.cars.commons.controller.PaginationParameters;
import com.cmymesh.service.demo.cars.commons.util.DateUtils;
import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.model.pojo.CarSummary;
import com.cmymesh.service.demo.cars.repository.CarsRepository;

@Service
public class CarsServiceImpl implements CarsService {

  // TODO : This could be declared as a bean.
  private ModelMapper entityToPojoModelMapper = null;
  private ModelMapper pojoToEntityModelMapper = null;

  @Autowired
  CarsRepository carsRepository;

  @Override
  public Optional<Car> addCar(Car car) {

    if (car == null || StringUtils.isEmpty(car.getMake())) {
      return Optional.empty();
    }

    com.cmymesh.service.demo.cars.model.entity.Car entity = pojoToEntityModelMapper().map(car,
        com.cmymesh.service.demo.cars.model.entity.Car.class);
    entity.setTimeCreated(new Date());
    entity.setTimeUpdated(new Date());
    // TODO : What is the difference ?
    carsRepository.saveAndFlush(entity);
    return Optional.of(car);
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Car> getCar(String carId) {
    Optional<com.cmymesh.service.demo.cars.model.entity.Car> entity = carsRepository.findById(carId);
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
    Optional<com.cmymesh.service.demo.cars.model.entity.Car> entity = carsRepository.findById(car.getPlate());
    if (!entity.isPresent()) {
      return Optional.empty();
    }
    carsRepository.save(pojoToEntityModelMapper().map(car, com.cmymesh.service.demo.cars.model.entity.Car.class));
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
    if (entityToPojoModelMapper != null) {
      return entityToPojoModelMapper;
    }
    entityToPojoModelMapper = new ModelMapper();
    TypeMap<com.cmymesh.service.demo.cars.model.entity.Car, Car> typeMap = entityToPojoModelMapper
        .createTypeMap(com.cmymesh.service.demo.cars.model.entity.Car.class, Car.class);

    Converter<Date, OffsetDateTime> toOffsetDateTime = new Converter<Date, OffsetDateTime>() {
      @Override
      public OffsetDateTime convert(MappingContext<Date, OffsetDateTime> context) {
        return DateUtils.dateToOffsetDateTime(context.getSource());
      }
    };
    entityToPojoModelMapper.addConverter(toOffsetDateTime);
    typeMap.addMappings(mapper -> {
      mapper.map(com.cmymesh.service.demo.cars.model.entity.Car::getId, Car::setPlate);
    });
    return entityToPojoModelMapper;
  }

  public ModelMapper pojoToEntityModelMapper() {
    if (pojoToEntityModelMapper != null) {
      return pojoToEntityModelMapper;
    }
    pojoToEntityModelMapper = new ModelMapper();
    TypeMap<Car, com.cmymesh.service.demo.cars.model.entity.Car> typeMap = pojoToEntityModelMapper
        .createTypeMap(Car.class, com.cmymesh.service.demo.cars.model.entity.Car.class);

    Converter<Date, OffsetDateTime> toOffsetDateTime = new Converter<Date, OffsetDateTime>() {
      @Override
      public OffsetDateTime convert(MappingContext<Date, OffsetDateTime> context) {
        return DateUtils.dateToOffsetDateTime(context.getSource());
      }
    };
    pojoToEntityModelMapper.addConverter(toOffsetDateTime);
    typeMap.addMappings(mapper -> {
      mapper.map(Car::getPlate, com.cmymesh.service.demo.cars.model.entity.Car::setId);
    });
    return pojoToEntityModelMapper;
  }

}
