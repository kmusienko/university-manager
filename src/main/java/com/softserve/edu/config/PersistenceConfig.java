package com.softserve.edu.config;

import com.softserve.edu.dao.FacultyDao;
import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.softserve.edu.*")
@PropertySource("classpath:db.properties")
public class PersistenceConfig {
    private static final String PROP_DB_DRIVER = "db.driver";
    private static final String PROP_DB_URL = "db.url";
    private static final String PROP_DB_USERNAME = "db.username";
    private static final String PROP_DB_PASSWORD = "db.password";
    private static final String PROP_DB_SHOW_SQL = "hibernate.show_sql";
    private static final String PROP_DB_GENERATE_DDL = "hibernate.hbm2ddl.auto";
    private static final String PROP_DB_DIALECT = "hibernate.dialect";
    //    private static final String PROR_DB_CURRENTSESSION =
    //            "current_session_context_class";

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
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        //        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.softserve.edu.model");

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(hibernateProperties());

        return factory;
    }

    @Bean
    public SessionFactory sessionFactory() {
        //       LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        LocalSessionFactoryBuilder builder =
                new LocalSessionFactoryBuilder(dataSource());
        builder.scanPackages("com.softserve.edu.model");
        builder.addAnnotatedClasses(Faculty.class, Speciality.class);
        builder.addProperties(hibernateProperties());
        //                factory.setDataSource(dataSource());
        //                factory.setPackagesToScan("com.softserve.edu.model");
        //                factory.setAnnotatedClasses(Faculty.class, Speciality.class);
        //                factory.setHibernateProperties(hibernateProperties());
        //        try {
        //            factory.afterPropertiesSet();
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //        }
        SessionFactory sessionFactory = builder.buildSessionFactory();
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        HibernateTransactionManager txManager =
                new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory());
        return txManager;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager =
                new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory
                (entityManagerFactoryBean().getObject());
        return jpaTransactionManager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty(PROP_DB_SHOW_SQL,
                               environment.getProperty(PROP_DB_SHOW_SQL));
        properties.setProperty(PROP_DB_GENERATE_DDL,
                               environment.getProperty(PROP_DB_GENERATE_DDL));
        properties.setProperty(PROP_DB_DIALECT,
                               environment.getProperty(PROP_DB_DIALECT));
        //        properties.setProperty(PROR_DB_CURRENTSESSION, environment
        //               .getProperty(PROR_DB_CURRENTSESSION));
        return properties;
    }

    //    @Bean
    //    public FacultyDao getFacultyDao() {
    //        return new FacultyDao();
    //    }
}
