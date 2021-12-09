package com.facu.disney.mapper;

import com.facu.disney.dto.ActorDTO;
import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.Movie;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    ActorMapper actorMapper;

    // movieDTO to movieEntity
    public Movie movieDTO2Entity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setImage(movieDTO.getImage());
        movie.setTitle(movieDTO.getTitle());
        movie.setCreationDate(this.string2LocalDate(movieDTO.getCreationDate()));
        movie.setQualification(movieDTO.getQualification());

        return movie;
    }

    // movieEntity to movieDTO
    public MovieDTO movieEntity2DTO(Movie movie, boolean loadActors) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setIdMovie(movie.getIdMovie());
        movieDTO.setImage(movie.getImage());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setCreationDate(movie.getCreationDate().toString());
        movieDTO.setQualification(movie.getQualification());
        //load actors list
        if (loadActors) {
            List<ActorDTO> actorsDTO = actorMapper.actorEntityList2DTOList(movie.getActors(), false);
            movieDTO.setActors(actorsDTO);
        }
        return movieDTO;
    }

    // movieEntity list to movieDTO list
    public List<MovieDTO> movieEntityList2DTOList(List<Movie> movies, boolean loadActors) {
        List<MovieDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(this.movieEntity2DTO(movie, loadActors));
        }
        return moviesDTO;
    }

    //movieEntity list to movieDTO list
    public List<MovieBasicDTO> movieEntityList2DTOBasicList(List<Movie> movies) {
        List<MovieBasicDTO> moviesDTO = new ArrayList<>();
        for (Movie movie : movies) {
            moviesDTO.add(this.movieEntity2DTOBasic(movie));
        }
        return moviesDTO;
    }

    //actorEntity to actorBasicDTO
    public MovieBasicDTO movieEntity2DTOBasic(Movie movie) {
        MovieBasicDTO movieBasicDTO = new MovieBasicDTO();
        movieBasicDTO.setImage(movie.getImage());
        movieBasicDTO.setTitle(movie.getTitle());
        movieBasicDTO.setCreationDate(movie.getCreationDate().toString());

        return movieBasicDTO;
    }

    //date type to string date type
    private LocalDate string2LocalDate(String creationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(creationDate, formatter);
        return date;
    }

    //update movie
    public void movieEntityUpdate(Movie movie, MovieDTO movieDTO) {
        movie.setImage(movieDTO.getImage());
        movie.setTitle(movieDTO.getTitle());
        movie.setCreationDate(this.string2LocalDate(movieDTO.getCreationDate()));
        movie.setQualification(movieDTO.getQualification());
    }
}
