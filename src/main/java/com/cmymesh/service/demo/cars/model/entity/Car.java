package com.cmymesh.service.demo.cars.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {

  @Id
  @Column(name = "cars_id")
  private String id;

  private String make;

  private String model;

  private String description;

  @Column(name = "type_of_use")
  private String typeOfUse;

  @Column(name = "national_key")
  private String nationalKey;

  @Column(name = "serial_number")
  private String serialNumber;

  @Column(name = "engine_serial_number")
  private String engineSerialNumber;

  private String company;

  @Column(name = "created_on")
  private Date createdOn;

  @Column(name = "created_by")
  private String createdBy;
}
