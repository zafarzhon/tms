package com.teachmeskills;

import com.teachmeskills.dto.Movie;
import com.teachmeskills.service.DbService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@WebServlet("/")
public class MoviesServlet extends HttpServlet {
    private DbService service = DbService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("movies",DbService.getInstance().getMovies());
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int releaseYear = Integer.parseInt(req.getParameter("release_year"));
        boolean isView = Boolean.parseBoolean(req.getParameter("isView"));
        service.addMovie(name,description,releaseYear,isView);
        resp.sendRedirect("/");
    }
}
