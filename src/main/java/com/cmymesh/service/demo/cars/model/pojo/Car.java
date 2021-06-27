package com.cmymesh.service.demo.cars.model.pojo;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * Main car object .
 */
@Builder
@ApiModel(description = "Main car object . ")
@Validated
@Data
public class Car implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("plate")
  private String plate = null;

  @JsonProperty("make")
  @NotNull
  private String make;

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

}
