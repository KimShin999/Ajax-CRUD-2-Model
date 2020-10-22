package controller;

import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.country.ICountryService;
import service.movie.IMovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("country")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("")
    public ModelAndView listMovie(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("movie", movieService.findAll());
        return modelAndView;
    }
}
