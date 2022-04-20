package hh.swd20.MovieStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.MovieStore.domain.MovieInfoRepository;



@CrossOrigin
@Controller
public class MovieInfoController {

	@Autowired
	private MovieInfoRepository repository;
	
	
	
}
