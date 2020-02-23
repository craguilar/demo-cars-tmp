package com.cmymesh.service.demo.cars.model.pojo;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Main car object .
 */
@ApiModel(description = "Main car object . ")
@Validated

public class Car implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("plate")
  private String plate = null;

  @JsonProperty("make")
  private String make = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("typeOfUse")
  private String typeOfUse = null;

  @JsonProperty("nationalKey")
  private String nationalKey = null;

  @JsonProperty("serialNumber")
  private String serialNumber = null;

  @JsonProperty("engineSerialNumber")
  private String engineSerialNumber = null;

  @JsonProperty("company")
  private String company = null;

  @JsonProperty("timeCreated")
  private OffsetDateTime timeCreated = null;

  @JsonProperty("timeUpdated")
  private OffsetDateTime timeUpdated = null;

  public Car plate(String plate) {
    this.plate = plate;
    return this;
  }

  /**
   * Car plate
   * 
   * @return plate
   **/
  @ApiModelProperty(required = true, value = "Car plate ")
  @NotNull

  public String getPlate() {
    return plate;
  }

  public void setPlate(String plate) {
    this.plate = plate;
  }

  public Car make(String make) {
    this.make = make;
    return this;
  }

  /**
   * Get make
   * 
   * @return make
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public Car model(String model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * 
   * @return model
   **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Car description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * 
   * @return description
   **/
  @ApiModelProperty(value = "")

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Car typeOfUse(String typeOfUse) {
    this.typeOfUse = typeOfUse;
    return this;
  }

  /**
   * Get typeOfUse
   * 
   * @return typeOfUse
   **/
  @ApiModelProperty(value = "")

  public String getTypeOfUse() {
    return typeOfUse;
  }

  public void setTypeOfUse(String typeOfUse) {
    this.typeOfUse = typeOfUse;
  }

  public Car nationalKey(String nationalKey) {
    this.nationalKey = nationalKey;
    return this;
  }

  /**
   * Get nationalKey
   * 
   * @return nationalKey
   **/
  @ApiModelProperty(value = "")

  public String getNationalKey() {
    return nationalKey;
  }

  public void setNationalKey(String nationalKey) {
    this.nationalKey = nationalKey;
  }

  public Car serialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  /**
   * Get serialNumber
   * 
   * @return serialNumber
   **/
  @ApiModelProperty(value = "")

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public Car engineSerialNumber(String engineSerialNumber) {
    this.engineSerialNumber = engineSerialNumber;
    return this;
  }

  /**
   * Get engineSerialNumber
   * 
   * @return engineSerialNumber
   **/
  @ApiModelProperty(value = "")

  public String getEngineSerialNumber() {
    return engineSerialNumber;
  }

  public void setEngineSerialNumber(String engineSerialNumber) {
    this.engineSerialNumber = engineSerialNumber;
  }

  public Car company(String company) {
    this.company = company;
    return this;
  }

  /**
   * Get company
   * 
   * @return company
   **/
  @ApiModelProperty(value = "")

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public Car timeCreated(OffsetDateTime timeCreated) {
    this.timeCreated = timeCreated;
    return this;
  }

  /**
   * Get timeCreated
   * 
   * @return timeCreated
   **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getTimeCreated() {
    return timeCreated;
  }

  public void setTimeCreated(OffsetDateTime timeCreated) {
    this.timeCreated = timeCreated;
  }

  public Car timeUpdated(OffsetDateTime timeUpdated) {
    this.timeUpdated = timeUpdated;
    return this;
  }

  /**
   * Get timeUpdated
   * 
   * @return timeUpdated
   **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getTimeUpdated() {
    return timeUpdated;
  }

  public void setTimeUpdated(OffsetDateTime timeUpdated) {
    this.timeUpdated = timeUpdated;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(this.plate, car.plate) && Objects.equals(this.make, car.make)
        && Objects.equals(this.model, car.model) && Objects.equals(this.description, car.description)
        && Objects.equals(this.typeOfUse, car.typeOfUse) && Objects.equals(this.nationalKey, car.nationalKey)
        && Objects.equals(this.serialNumber, car.serialNumber)
        && Objects.equals(this.engineSerialNumber, car.engineSerialNumber) && Objects.equals(this.company, car.company)
        && Objects.equals(this.timeCreated, car.timeCreated) && Objects.equals(this.timeUpdated, car.timeUpdated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plate, make, model, description, typeOfUse, nationalKey, serialNumber, engineSerialNumber,
        company, timeCreated, timeUpdated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Car {\n");

    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    typeOfUse: ").append(toIndentedString(typeOfUse)).append("\n");
    sb.append("    nationalKey: ").append(toIndentedString(nationalKey)).append("\n");
    sb.append("    serialNumber: ").append(toIndentedString(serialNumber)).append("\n");
    sb.append("    engineSerialNumber: ").append(toIndentedString(engineSerialNumber)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    timeCreated: ").append(toIndentedString(timeCreated)).append("\n");
    sb.append("    timeUpdated: ").append(toIndentedString(timeUpdated)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
