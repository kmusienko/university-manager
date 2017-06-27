package com.softserve.edu.config;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Created by Kostya on 11.06.2017.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.softserve.edu.dao")
@PropertySource("classpath:db.properties")
public class PersistenceConfig {
    private static final String PROP_DB_DRIVER = "db.driver";
    private static final String PROP_DB_URL = "db.url";
    private static final String PROP_DB_USERNAME = "db.username";
    private static final String PROP_DB_PASSWORD = "db.password";
    private static final String PROP_DB_SHOW_SQL = "hibernate.show_sql";
    private static final String PROP_DB_GENERATE_DDL = "hibernate.hbm2ddl.auto";
    private static final String PROP_DB_DIALECT = "hibernate.dialect";

    @Autowired
    private Environment environment;

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(environment.getProperty(PROP_DB_DRIVER));
        ds.setUrl(environment.getProperty(PROP_DB_URL));
        ds.setUsername(environment.getProperty(PROP_DB_USERNAME));
        ds.setPassword(environment.getProperty(PROP_DB_PASSWORD));
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factory = new
                LocalContainerEntityManagerFactoryBean();
//        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.softserve.edu.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(hibernateProperties());

        return factory;
    }

    @Bean
    public SessionFactory sessionFactory() {
      //  LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder
                (dataSource());
        builder.scanPackages("com.softserve.edu.model");
        builder.addAnnotatedClasses(Faculty.class, Speciality.class);
        builder.addProperties(hibernateProperties());
//        factory.setDataSource(dataSource());
//        factory.setPackagesToScan("com.softserve.edu.model");
//        factory.setAnnotatedClasses(Faculty.class, Speciality.class);
//        factory.setHibernateProperties(hibernateProperties());
      //  factory.afterPropertiesSet();
        return builder.buildSessionFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(PROP_DB_SHOW_SQL, environment.getProperty(PROP_DB_SHOW_SQL));
        properties.setProperty(PROP_DB_GENERATE_DDL, environment.getProperty(PROP_DB_GENERATE_DDL));
        properties.setProperty(PROP_DB_DIALECT, environment.getProperty(PROP_DB_DIALECT));
        return properties;
    }
}
