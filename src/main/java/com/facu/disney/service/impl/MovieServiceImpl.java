package com.facu.disney.service.impl;

import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.entity.MovieEntity;
import com.facu.disney.exception.InvalidParam;
import com.facu.disney.mapper.MovieMapper;
import com.facu.disney.repository.MovieRepository;
import com.facu.disney.service.MovieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieMapper movieMapper;

    //get basic list movies
    @Override
    public List<MovieBasicDTO> getBasicList() {
        List<MovieEntity> entities = this.movieRepository.findAll();
        List<MovieBasicDTO> result = this.movieMapper.movieEntityList2DTOBasicList(entities);

        return result;
    }

    //get details by id
    @Override
    public MovieDTO getDetailsById(Long idMovie) {

        Optional<MovieEntity> entity = this.movieRepository.findById(idMovie);

        if (!entity.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        MovieDTO movie = this.movieMapper.movieEntity2DTO(entity.get(), true);

        return movie;
    }

    //method save movie
    @Override
    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = this.movieMapper.movieDTO2Entity(dto);
        MovieEntity movieSaved = this.movieRepository.save(entity);
        MovieDTO result = this.movieMapper.movieEntity2DTO(movieSaved, false);

        return result;
    }

    //method update movie
    @Override
    public MovieDTO update(MovieDTO dto, Long idMovie) {
        Optional<MovieEntity> entity = this.movieRepository.findById(idMovie);

        if (!entity.isPresent()) {
            throw new InvalidParam("El id ingresado no existe.");
        }
        this.movieMapper.movieEntityUpdate(entity.get(), dto);
        MovieEntity movieSaved = this.movieRepository.save(entity.get());
        MovieDTO result = this.movieMapper.movieEntity2DTO(movieSaved, false);

        return result;
    }

    //method delete movie
    @Override
    public void delete(Long idMovie) {
        this.movieRepository.deleteById(idMovie);
    }

}
