package com.facu.disney.service.impl;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.entity.GenreEntity;
import com.facu.disney.mapper.GenreMapper;
import com.facu.disney.repository.GenreRepository;
import com.facu.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreMapper genreMapper;
    @Autowired
    GenreRepository genreRepository;

    @Override
    public GenreDTO save(GenreDTO dto) {

        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity genreSaved = genreRepository.save(entity);
        GenreDTO result = genreMapper.genreEntity2DTO(genreSaved);

        return result;
    }

}
