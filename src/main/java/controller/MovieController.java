package controller;

import model.Country;
import model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/create")
    public ResponseEntity<Movie> create(@RequestBody Movie movie){
        movieService.save(movie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Movie>> findAll(){
        return new ResponseEntity<>(movieService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Iterable<Movie>> findAllByName(@PathVariable String name){
        return new ResponseEntity<>(movieService.findAllByNameContaining(name), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Movie> delete(@PathVariable Long id){
        movieService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
