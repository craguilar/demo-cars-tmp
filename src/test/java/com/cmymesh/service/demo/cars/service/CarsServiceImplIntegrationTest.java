package com.cmymesh.service.demo.cars.service;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cmymesh.service.demo.cars.model.pojo.Car;
import com.cmymesh.service.demo.cars.repository.CarsRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class CarsServiceImplIntegrationTest {

  @Autowired
  CarsRepository carsRepository;

  @Test
  void addCarTest() throws InterruptedException {

    CarsService carService = new CarsServiceImpl(carsRepository);

    Callable<Optional<Car>> thread = () -> {
      return carService.addCar(Car.builder().company("Test").plate("CAGDL-001").build());
    };
    List<Future<Optional<Car>>> results = new ArrayList<>();
    ExecutorService executor = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 5; i++) {
      results.add(executor.submit(thread));
    }

    Optional<Future<Optional<Car>>> pending = results.stream().filter(f -> !f.isDone()).findAny();

    while (pending.isPresent()) {
      pending = results.stream().filter(f -> !f.isDone()).findAny();
      await().atMost(10, TimeUnit.MILLISECONDS);
    }
    long count = carsRepository.count();
    assertEquals(1, count);
  }
}
