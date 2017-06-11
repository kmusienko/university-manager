package com.softserve.edu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Kostya on 11.06.2017.
 */
@Configuration
@Import(PersistenceConfig.class)
@ComponentScan("com.softserve.edu.service")
public class RootConfig {
}
