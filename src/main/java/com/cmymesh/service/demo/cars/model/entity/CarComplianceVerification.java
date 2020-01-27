package com.cmymesh.service.demo.cars.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "car_compliance_verification")
public class CarComplianceVerification {

  @Id
  @Column(name = "car_compliance_verirication_id")
  private String id;

  @Column(name = "from_date")
  private Date fromDate;

  @Column(name = "to_date")
  private Date toDate;

  @Column(name = "next_date")
  private Date nextDate;
}
