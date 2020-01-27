package com.cmymesh.service.demo.cars.configuration;

import java.time.OffsetDateTime;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cmymesh.service.demo.cars.configuration.serialization.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Class that configures JSON Default mapper with the purpose of have more
 * control over auto configuration.
 * 
 * @author caruruiz
 *
 */
@Configuration
public class JsonConfiguration {

  @Bean
  @Primary
  public ObjectMapper customJson() {
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.setTimeZone(TimeZone.getTimeZone("UTC"));
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.setSerializationInclusion(Include.NON_NULL);

    objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));

    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(OffsetDateTime.class, new CustomDateSerializer());
    objectMapper.registerModule(simpleModule);

    return objectMapper;
  }

}