package platform.codingnomads.co.lab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// use of @ContextConfiguration or @ContextHierarchy??
@SpringBootTest(classes = SpringTestLab.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MovieRepository movieRepo;

    @MockBean
    private MovieServiceImpl movieServiceMock;

    @Test
    public void testGetAllMoviesSuccess() {
        try {
            this.mockMvc.perform(get("/all"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(jsonPath("$", hasSize(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      // Failure behaviour > 2 entries in database or none?
//    @Test
//    public void testGetAllMoviesFailure() {
//
//    }

      // Mock MovieService to create list of Movies
    @Test
    public void testGetAllMoviesSuccessMockService() throws Exception {
        Movie movie = Movie.builder().name("Parasite").rating(8.0).build();
        Movie anotherMovie = Movie.builder().name("Goodfellas").rating(9.1).build();

        List<Movie> movieList = new ArrayList<>();
        movieList.add(movie);
        movieList.add(anotherMovie);

        when(movieServiceMock.getAllMovies()).thenReturn(movieList);

        mockMvc.perform(get("/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)));
    }
}