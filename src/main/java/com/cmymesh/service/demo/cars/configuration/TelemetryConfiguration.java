package com.cmymesh.service.demo.cars.configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cmymesh.service.demo.cars.commons.ApplicationConstants;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class TelemetryConfiguration {

  private static final String DEFAULT_HOSTNAME = "alpha-host";

  @Bean
  public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
    return registry -> registry.config().commonTags("vm-host", getHostName(), "application",
        ApplicationConstants.APPLICATION_NAME);
  }

  private String getHostName() {
    try {
      return InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException e) {
      return DEFAULT_HOSTNAME;
    }
  }
}
