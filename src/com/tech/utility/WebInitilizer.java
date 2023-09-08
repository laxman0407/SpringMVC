package com.tech.utility;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {

		AnnotationConfigWebApplicationContext acf = new AnnotationConfigWebApplicationContext();

		acf.register(AppConfig.class);
		acf.setServletContext(sc);

		ServletRegistration.Dynamic srd = sc.addServlet("DispatcherServlet", new DispatcherServlet(acf));
		srd.addMapping("/");
	}

}
