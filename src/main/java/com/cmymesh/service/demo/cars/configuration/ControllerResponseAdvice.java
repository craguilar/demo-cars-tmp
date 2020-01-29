package com.cmymesh.service.demo.cars.configuration;

import java.net.URI;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@ControllerAdvice

public class ControllerResponseAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object arg0, MethodParameter arg1, MediaType arg2,
      Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {

    String fields = getUriQueryFieldsParameter(arg4.getURI());
    if (fields != null) {
      MappingJacksonValue wrapper = new MappingJacksonValue(arg0);
      wrapper.setFilters(new SimpleFilterProvider().addFilter("fieldsFilter",
          SimpleBeanPropertyFilter.filterOutAllExcept(fields.split(","))));
      return wrapper;
    }
    return arg0;
  }

  protected static String getUriQueryFieldsParameter(URI uri) {
    List<String> fields = null;
    String returnValue = null;
    String query = uri.getQuery();
    if (query != null && query.contains("fields")) {
      MultiValueMap<String, String> parameters = UriComponentsBuilder.fromUri(uri).build().getQueryParams();
      fields = parameters.get("fields");
    }
    if (fields != null && fields.get(0) != null) {
      returnValue = fields.get(0);
    }
    return returnValue;
  }

}