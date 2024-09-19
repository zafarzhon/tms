package com.teachmeskills.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public class ServletConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet(
                "dispatcher",dispatcherServlet);
        registration.addMapping("/");
        registration.setLoadOnStartup(1);
    }
}
