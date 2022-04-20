package hh.swd20.MovieStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.MovieStore.domain.Category;
import hh.swd20.MovieStore.domain.Movie;
import hh.swd20.MovieStore.domain.MovieRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository repository;
	
	Category c1 = new Category(1, "Action");
	
	@Test  // testataan Movierepositoryn findBymoviename()-metodin toimivuutta
    public void findByMovieNameShouldReturnMovie() {
        List<Movie> movies = repository.findBymoviename("God Father");
        
        assertThat(movies).hasSize(1);
        assertThat(movies.get(9).getMoviename()).isEqualTo("God Father");
    }
    
    @Test // testataan MovieRepositoryn save()-metodin toimivuutta
    public void createNewMovie() {
    	Movie m1 = new Movie("God Father", null, c1);
    	repository.save(m1);
    	assertThat(m1.getId()).isNotNull();
    }    
}
