package com.teachmeskills.config;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *  @author zafarzhon
 *  @link <a href="https://github.com/zafarzhon">github</a>
 */
//@RequiredArgsConstructor
public class ServletConfig implements WebApplicationInitializer {
//    private final JdbcTemplate jdbcTemplate;
    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet(
                "dispatcher",dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
//        jdbcTemplate.execute("""
////            create table if not exists movies(
////            id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
////            name varchar(30),
////            description varchar(30),
////            release_year smallint,
////            is_view boolean);
////            """);

    }
}
