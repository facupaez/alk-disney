package com.facu.disney.service.impl;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.entity.Genre;
import com.facu.disney.mapper.GenreMapper;
import com.facu.disney.repository.GenreRepository;
import com.facu.disney.service.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;
    @Autowired
    GenreRepository genreRepository;

    //save genre
    @Override
    public GenreDTO save(GenreDTO dto) {

        Genre genre = genreMapper.genreDTO2Entity(dto);
        Genre genreSaved = genreRepository.save(genre);
        GenreDTO result = genreMapper.genreEntity2DTO(genreSaved);

        return result;
    }

    //all genre list
    @Override
    public List<GenreDTO> getAllGenres() {
        
        List<Genre> genres = genreRepository.findAll();
        List<GenreDTO> result = genreMapper.genreEntityList2DTOList(genres);
        
        return result;
    }

}
