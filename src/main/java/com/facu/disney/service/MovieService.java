package com.facu.disney.service;

import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import java.util.List;

public interface MovieService {

    public List<MovieBasicDTO> getBasicList();

    public MovieDTO getDetailsById(Long idMovie);

    public MovieDTO save(MovieDTO movie);

    public MovieDTO update(MovieDTO movie, Long idMovie);

    public void delete(Long idMovie);
    
}
