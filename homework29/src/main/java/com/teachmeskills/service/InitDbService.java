package com.teachmeskills.service;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class InitDbService extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("""
            create table if not exists movies(
            id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
            name varchar(30),
            description varchar(30),
            release_year smallint,
            is_view boolean);
            """);
            connection.close();
        } catch (SQLException e) {
            System.out.println("init: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost" +
                    "/movie?user=postgres&password=root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
