package hh.swd20.MovieStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
List<Movie> findBymoviename(String moviename);
}
