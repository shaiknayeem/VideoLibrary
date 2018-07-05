package com.videolibrary.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile("DEV")
@PropertySource("classpath:${configfile.path}/dev.properties")
public class DevConfig {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
}
