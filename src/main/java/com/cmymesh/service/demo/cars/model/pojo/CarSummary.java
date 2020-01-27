package com.cmymesh.service.demo.cars.model.pojo;

import java.io.Serializable;
import java.util.Objects;

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

public class CarSummary implements Serializable {
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

  public CarSummary plate(String plate) {
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

  public CarSummary make(String make) {
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

  public CarSummary model(String model) {
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

  public CarSummary description(String description) {
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

  public CarSummary typeOfUse(String typeOfUse) {
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

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarSummary carSummary = (CarSummary) o;
    return Objects.equals(this.plate, carSummary.plate) && Objects.equals(this.make, carSummary.make)
        && Objects.equals(this.model, carSummary.model) && Objects.equals(this.description, carSummary.description)
        && Objects.equals(this.typeOfUse, carSummary.typeOfUse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plate, make, model, description, typeOfUse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CarSummary {\n");

    sb.append("    plate: ").append(toIndentedString(plate)).append("\n");
    sb.append("    make: ").append(toIndentedString(make)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    typeOfUse: ").append(toIndentedString(typeOfUse)).append("\n");
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
