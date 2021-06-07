package com.springselenium.automation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPlaceholderConfigurer() {

		String propertiesPath = "/application.properties";
		
		PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
		properties.setLocation(new ClassPathResource(propertiesPath));
		properties.setIgnoreResourceNotFound(false);
		
		return properties;
	}
}
