package hh.swd20.MovieStore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import hh.swd20.MovieStore.web.MovieController;
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
@SpringBootTest
class MovieStoreApplicationTests {

	@Autowired
	private MovieController movieController;
	
	
	@Test
	void contextLoads() {
		assertThat(movieController).isNotNull();
	}

}
