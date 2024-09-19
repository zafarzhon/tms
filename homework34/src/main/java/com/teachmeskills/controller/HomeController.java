package com.teachmeskills.controller;

import com.teachmeskills.dto.MovieDto;
import com.teachmeskills.entities.MovieEntity;
import com.teachmeskills.exceptions.MovieException;
import com.teachmeskills.mapper.MovieMapper;
import com.teachmeskills.service.DataBaseService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class HomeController {
    private final DataBaseService dataBaseService;
    private final MovieMapper movieMapper;


    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/movies")
    public String getAll(Model model) {
        List<MovieEntity> all = dataBaseService.getAll();
        model.addAttribute("movies", all);
        return "index";
    }

    @GetMapping("/movies/add")
    public String add(@ModelAttribute("movieDto") MovieDto movieDto) {
        return "create";
    }

    @PostMapping("/movies/add")
    public String homePost(@ModelAttribute("movieDto") @Valid MovieDto movieDto,
                           BindingResult bindingResult,
                           Model model) {
        if (!bindingResult.hasErrors()) {
            MovieEntity movieEntity = movieMapper.mapToMovieEntity(movieDto);
            dataBaseService.save(movieEntity);
            model.addAttribute("movieDto", new MovieDto());
        }
        return "create";
    }

    //    @ExceptionHandler("MovieException.class")
    @GetMapping("/movies/edit")
    public String editGetWithParam(@RequestParam("id") UUID id,
                                   @ModelAttribute("movieDto") MovieDto movieDto,
                                   Model model) {
        MovieEntity movieByIdFound = dataBaseService.findMovieById(id);
        MovieDto movieDtoFound = movieMapper.mapToMovieDto(movieByIdFound);
        model.addAttribute("id", id);
        model.addAttribute("movieDto", movieDtoFound);
        return "edit";
    }

    @PostMapping("/movies/edit")
    public String editPost(@RequestParam("id") UUID id,
                           @ModelAttribute("movieDto")
                           @Valid MovieDto movieDto,
                           BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            MovieEntity movieEntity = new MovieEntity(id, movieDto);
            dataBaseService.update(movieEntity);
            return "redirect:/app/movies";
        }
        model.addAttribute("id", id);
        model.addAttribute("movieDto", movieDto);
        return "edit";
    }

    @SneakyThrows
    @GetMapping("/movies/delete")
    public void delete(@RequestParam("id") UUID id, HttpServletResponse resp) {
        dataBaseService.delete(id);
        resp.sendRedirect("/app/movies");
    }

    @ExceptionHandler(MovieException.class)
    public String processError() {
        return "errors";
    }
}
