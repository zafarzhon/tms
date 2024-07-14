package com.teachmeskills;

import com.teachmeskills.dto.Movie;
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
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private DbService service = DbService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        Movie movie = service.findByIdMovie(id);
        req.setAttribute("movie",movie);
        req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int releaseYear = Integer.parseInt(req.getParameter("release_year"));
        boolean isView = Boolean.parseBoolean(req.getParameter("isView"));
        Movie movie = service.findByIdMovie(id);
        movie.setName(name);
        movie.setDescription(description);
        movie.setReleaseYear(releaseYear);
        movie.setIsView(isView);
        service.editMovie(movie);
        resp.sendRedirect("/");
    }
}
