package com.teachmeskills.controller;

import com.teachmeskills.dto.Movie;
import com.teachmeskills.service.DataBaseService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping(value = "/movie")
@RequiredArgsConstructor
public class HomeController {
    private final DataBaseService dataBaseService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        List<Movie> all = dataBaseService.getAll();
        model.addAttribute("movies", all);
        return "index";
    }

    @PostMapping("/home")
    public void add(HttpServletResponse resp,
                      @RequestParam(name = "name") String name,
                      @RequestParam(name = "description") String description,
                      @RequestParam(name = "release_year") Integer releaseYear,
                      @RequestParam(name = "isView") Boolean isView) throws IOException {
        dataBaseService.save(name, description, releaseYear, isView);
        resp.sendRedirect("/movie/home");

    }

    @GetMapping("/delete")
    public void delete(HttpServletResponse resp,
                       @RequestParam(name = "id") UUID id) throws IOException {
        dataBaseService.delete(id);
        resp.sendRedirect("/movie/home");

    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") UUID id, Model model) {
        Movie movieById = dataBaseService.getMovieById(id);
        model.addAttribute("movie", movieById);
        return "edit";
    }

    @PostMapping("/edit")
    public void edit(HttpServletResponse resp,
                       @RequestParam(name="id") UUID id,
                       @RequestParam(name = "name") String name,
                       @RequestParam(name = "description") String description,
                       @RequestParam(name = "release_year") Integer releaseYear,
                       @RequestParam(name = "isView") Boolean isView) throws IOException {
        dataBaseService.update(id,name,description,releaseYear,isView);
        resp.sendRedirect("/movie/home");
    }

}
