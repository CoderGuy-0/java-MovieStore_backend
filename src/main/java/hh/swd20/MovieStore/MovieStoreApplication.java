package hh.swd20.MovieStore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.validator.spi.messageinterpolation.LocaleResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import hh.swd20.MovieStore.domain.Category;
import hh.swd20.MovieStore.domain.CategoryRepository;
import hh.swd20.MovieStore.domain.Movie;
import hh.swd20.MovieStore.domain.MovieInfo;
import hh.swd20.MovieStore.domain.MovieInfoRepository;
import hh.swd20.MovieStore.domain.MovieRepository;

//import hh.swd20.MovieStore.domain.StoreRepository;
import hh.swd20.MovieStore.domain.UserRepository;
import hh.swd20.MovieStore.domain.User;

@SpringBootApplication
public class MovieStoreApplication {

	private static final Logger log = LoggerFactory.getLogger(MovieStoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MovieStoreApplication.class, args);
	}
	
	   
		@Bean
		public CommandLineRunner movieDemo(MovieRepository repository,UserRepository urepository, CategoryRepository crepository, MovieInfoRepository mirepository)
		{
			return (args) -> {
				
				
				
				log.info("tallennan pari kategoriaa");
				Category c1 = new Category(1, "Action");
				crepository.save(c1);
				Category c2 = new Category(2, "Comedy");
				crepository.save(c2);
				Category c3 = new Category(3, "Drama");
				crepository.save(c3);
				Category c4 = new Category(4, "Fantasy");
				crepository.save(c4);
				Category c5 = new Category(5, "Horror");
				crepository.save(c5);
				Category c6 = new Category(6, "Mystery");
				crepository.save(c6);
				Category c7 = new Category(7, "Romance");
				crepository.save(c7);
				Category c8 = new Category(8, "Thriller");
				crepository.save(c8);
				
				log.info("tallennan pari elokuvaa");
				Movie m1 = new Movie("God Father", new SimpleDateFormat("dd/MM/yyyy").parse("15/03/1972"), c1);
				repository.save(m1);
				Movie m2 = new Movie("Dark Knight", new SimpleDateFormat("dd/MM/yyyy").parse("24/07/2008"), c2);
				repository.save(m2);
				Movie m3 = new Movie("Forrest Gump", new SimpleDateFormat("dd/MM/yyyy").parse("07/10/1994"), c3);
				repository.save(m3);
				
				log.info("Tallennnan elokuvien tietoja (juoni voi olla vain 255 chars)"); 
				MovieInfo mi1 = new MovieInfo("The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.", 
						"Marlon Brando (Don Vito Corlone)", "Al Pacino (Michael)", "James Caan (Sonny)", "Robert Duvall (Tom Hagen)", "Al Lettieri (Sollozzo)");
				mirepository.save(mi1);
				
				
				log.info("Hae kaikki elokuvat");
				for (Movie movie : repository.findAll()) {
				log.info(movie.toString());
				}
				log.info("Hae Kaikkien elokuvien Infot");
				for (MovieInfo movieinfolist : mirepository.findAll()) { 
				log.info(movieinfolist.toString());
				}
				User user1 = new User("user", "$2a$10$k6s9b6rVY87GLwUqGz5nWOtV8meS4muLzM1ovyb4lWxrXZRgGh.fG", "USER");
				urepository.save(user1);
				User user2 = new User("admin", "$2a$10$VGOOjYUgpnzFLjfgQgAdCOa2n4GbtrXEb6Putghv6p82e3WuKaZuW", "ADMIN");
				urepository.save(user2);	

};
}
}
	
