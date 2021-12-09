package com.facu.disney.service.impl;

import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.dto.MovieFiltersDTO;
import com.facu.disney.entity.Movie;
import com.facu.disney.exception.InvalidParam;
import com.facu.disney.mapper.MovieMapper;
import com.facu.disney.repository.MovieRepository;
import com.facu.disney.repository.specification.MovieSpecification;
import com.facu.disney.service.MovieService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MovieSpecification movieSpecification;

    //get basic list movies
    @Override
    public List<MovieBasicDTO> getBasicList() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieBasicDTO> result = movieMapper.movieEntityList2DTOBasicList(movies);

        return result;
    }

    //get details by id
    @Override
    public MovieDTO getDetailsById(Long idMovie) {

        Optional<Movie> movieOp = movieRepository.findById(idMovie);

        if (!movieOp.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        MovieDTO movieDTO = movieMapper.movieEntity2DTO(movieOp.get(), true);

        return movieDTO;
    }

    //method save movie
    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        Movie movie = movieMapper.movieDTO2Entity(movieDTO);
        Movie movieSaved = movieRepository.save(movie);
        MovieDTO result = movieMapper.movieEntity2DTO(movieSaved, false);

        return result;
    }

    //method update movie
    @Override
    public MovieDTO update(MovieDTO movieDTO, Long idMovie) {
        Optional<Movie> movieOp = movieRepository.findById(idMovie);

        if (!movieOp.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        this.movieMapper.movieEntityUpdate(movieOp.get(), movieDTO);
        Movie movieSaved = movieRepository.save(movieOp.get());
        MovieDTO result = movieMapper.movieEntity2DTO(movieSaved, false);

        return result;
    }

    //method delete movie
    @Override
    public void delete(Long idMovie) {
        Optional<Movie> movieOp = movieRepository.findById(idMovie);

        if (!movieOp.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        Movie movie = movieOp.get();
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    // method get details by country using filters
    @Override
    public List<MovieDTO> getDetailsByFilters(String title, Set<Long> genre, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, genre, order);
        List<Movie> movies = movieRepository.findAll(movieSpecification.getMovieByFilters(filtersDTO));
        List<MovieDTO> moviesDTO = movieMapper.movieEntityList2DTOList(movies, true);
        return moviesDTO;
    }

}
