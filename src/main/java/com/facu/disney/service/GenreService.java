package com.facu.disney.service;

import com.facu.disney.dto.GenreDTO;
import java.util.List;

public interface GenreService {

    public GenreDTO save(GenreDTO genre);

    public List<GenreDTO> getAllGenres();
    
}
