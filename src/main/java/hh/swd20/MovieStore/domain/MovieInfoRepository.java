package hh.swd20.MovieStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MovieInfoRepository extends CrudRepository<MovieInfo, Long>{

	List<MovieInfo> findByactor(String actor);
}
