package com.cmymesh.service.demo.cars.model.pojo;

import java.io.Serializable;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Internal error object model.
 */
@ApiModel(description = "Internal error object model.")
@Validated
@Data
public class Error implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

}
