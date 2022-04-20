package hh.swd20.MovieStore.web;

import java.util.List;
import java.util.Locale;
import java.util.Optional;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import hh.swd20.MovieStore.domain.CategoryRepository;
import hh.swd20.MovieStore.domain.Movie;
import hh.swd20.MovieStore.domain.MovieInfo;
import hh.swd20.MovieStore.domain.MovieInfoRepository;
import hh.swd20.MovieStore.domain.MovieRepository;

@CrossOrigin
@Controller

public class MovieController {

	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private MovieInfoRepository mirepository;
	
	@Autowired
	private MessageSource messageSource;
	

	
	// Show all books
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
        
    }
    
    @RequestMapping(value="/movielist", method=RequestMethod.GET)
    public String ListMovies (Locale locale, Model model, HttpServletRequest request) {
    	
    	model.addAttribute("movies", repository.findAll());
    	
    
    	model.addAttribute("welcome","Welcome");
    	model.addAttribute("tothemoviestore","To The Movie Store!");
    	
    	
    	Locale currentLocale = LocaleContextHolder.getLocale();
    	model.addAttribute("locale",currentLocale);
    	
    	return "moviestore";
    }
    
    @RequestMapping(value="/movieinformations", method=RequestMethod.GET)
	public String ListMovieInfos (Model model) {
		model.addAttribute("movieinfolist", mirepository.findAll());
		
		return "movieinfo";
	}
    
 // RESTful service to get all Movies
    // Java-kielinen Student-luokan oliolista muunnetaan JSON-opiskelijalistaksi ja 
    // lähetetään web-selaimelle vastauksena
    @RequestMapping(value="/movies", method = RequestMethod.GET)
    public @ResponseBody List<Movie> movieListRest() {	
        return (List<Movie>) repository.findAll();
    }
    
 // RESTful service to get movie by id
    @RequestMapping(value="/movies/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Movie> findMovieRest(@PathVariable("id") Long movieId) {	
    	return repository.findById(movieId);
    }      
    
    // RESTful service to save new movie
    @RequestMapping(value="/movies", method = RequestMethod.POST)
    public @ResponseBody Movie saveMovieRest(@RequestBody Movie movie) {	
    	return repository.save(movie);
    }
 // RESTful service to get all Movie infos
    @RequestMapping(value="/movieinfos", method = RequestMethod.GET)
    public @ResponseBody List<MovieInfo> movieInfoListRest() {	
        return (List<MovieInfo>) mirepository.findAll();
    }
	
	@RequestMapping(value="/add")
	public String addMovie (Model model)
	{
		model.addAttribute("movie", new Movie());
		model.addAttribute("categories", crepository.findAll());
		return "addmovie";
	}
	
	@RequestMapping(value="/addm") // lukee siellä osoitevalikossa
	public String addMovieInfo (Model model)
	{
		model.addAttribute("movieinfolist", new MovieInfo());
		return "addmovieinfo";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveMovie (Movie movie)
	{
		repository.save(movie);
		return "redirect:movielist";
	}
	@RequestMapping(value="/saveinfo", method=RequestMethod.POST)
	public String saveMovieInfo (MovieInfo movieinfolist) {
		mirepository.save(movieinfolist);
		return "redirect:movieinformations";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteMovie (@PathVariable("id") Long movieId, Model model)
	{
		repository.deleteById(movieId);
		return "redirect:../movielist";
	}
	
	@RequestMapping(value="/show/{id}", method=RequestMethod.GET)
	public String GotoMovieInfo (@PathVariable("id") Long movieinfoId, Model model) {
		
		mirepository.findById(movieinfoId);
		return "movieinfo";
	}
	
	
    
    
    
    
}
