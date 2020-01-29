package com.cmymesh.service.demo.cars.commons.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationParameters {

  private Integer limit;

  private String page;

  private String sortOrder;

  private String sortBy;

}
