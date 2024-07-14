package com.teachmeskills;

import com.teachmeskills.service.DbService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private DbService service = DbService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        service.deleteByIdMovie(id);
        resp.sendRedirect("/");
    }
}
