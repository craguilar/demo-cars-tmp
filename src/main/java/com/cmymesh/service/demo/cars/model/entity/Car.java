package com.cmymesh.service.demo.cars.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    private Date timeCreated;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_on")
    private Date timeUpdated;

    @Column(name = "updated_by")
    private String updatedBy;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }
        Car car = (Car) obj;
        return getId() != null && Objects.equals(getId(), car.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
