package ua.com.andromeda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.andromeda.entities.Movie;
import ua.com.andromeda.services.MovieService;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/home")
    public String home(Model model){
        List<Movie> distinctMovies = movieService.findDistinctMovies();
        model.addAttribute("movies", distinctMovies);
        return "movies/home";
    }
}
