package com.cmymesh.service.demo.cars.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "car_documents")
public class CarDocument {

  @Id
  @Column(name = "car_documents_id")
  private String id;

  private String type;

  @Column(name = "expedition_date")
  private Date expeditionDate;

  @Column(name = "expiring_date")
  private Date expiringDate;
}
