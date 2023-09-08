package com.tech.utility;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "com.tech")
@Configuration
public class AppConfig {
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver irvr = new InternalResourceViewResolver();

		irvr.setSuffix(".jsp");
		return irvr;

	}

	@Bean
	public DriverManagerDataSource dmds() {

		DriverManagerDataSource d = new DriverManagerDataSource();

		d.setDriverClassName("com.mysql.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/bankprojectspringmvc");
		d.setUsername("root");
		d.setPassword("Root");
		return d;

	}

	@Bean
	public LocalSessionFactoryBean sf() {

		LocalSessionFactoryBean lsf = new LocalSessionFactoryBean();

		lsf.setDataSource(dmds());

		Properties p = new Properties();

		p.setProperty("org.hibernate.dialect.MySQL55Dialect", "hibernate.dialect");
		p.setProperty("hibernate.hbm2ddl.auto", "update");

		lsf.setHibernateProperties(p);
		lsf.setAnnotatedClasses(com.tech.model.Customer.class);

		return lsf;

	}

}
