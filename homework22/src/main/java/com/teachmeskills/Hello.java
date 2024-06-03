package com.teachmeskills;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Hello extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Initializing Servlet");
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service doing");
        super.service(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter writer = res.getWriter();
        LocalDateTime now = LocalDateTime.now();
        writer.println("""
                <html>
                <head>
                    <title>Hello</title>
                </head>
                <body>
                """ + now + """
                </body>
                </html>
                """);
    }
}
