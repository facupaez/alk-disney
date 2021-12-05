package com.facu.disney.controller;

import com.facu.disney.dto.GenreDTO;
import com.facu.disney.service.GenreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> saveGenre(@RequestBody GenreDTO genre) {

        GenreDTO genreSaved = this.genreService.save(genre);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(genreSaved);
    }
    
    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAllGenres(){
        
        List<GenreDTO> genres = this.genreService.getAllGenres();
        
        return ResponseEntity.ok().body(genres);
    }
}
