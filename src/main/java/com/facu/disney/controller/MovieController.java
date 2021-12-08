package com.facu.disney.controller;

import com.facu.disney.dto.MovieBasicDTO;
import com.facu.disney.dto.MovieDTO;
import com.facu.disney.service.MovieService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //basic movies list
    @GetMapping("/basic")
    public ResponseEntity<List<MovieBasicDTO>> getBasicList() {

        List<MovieBasicDTO> movies = this.movieService.getBasicList();

        return ResponseEntity.ok().body(movies);
    }

    //get details by id
    @GetMapping("/{idMovie}")
    public ResponseEntity<MovieDTO> getDetailsById(@PathVariable Long idMovie) {

        MovieDTO movieById = this.movieService.getDetailsById(idMovie);

        return ResponseEntity.ok(movieById);
    }

    //save movie
    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie) {

        MovieDTO movieSaved = this.movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }

    //update movie
    @PutMapping("/{idMovie}")
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO movie, @PathVariable Long idMovie) {

        MovieDTO movieUpdated = this.movieService.update(movie, idMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieUpdated);
    }

    //delete movie
    @DeleteMapping("/{idMovie}")
    public ResponseEntity<Void> detele(@PathVariable Long idMovie) {

        this.movieService.delete(idMovie);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //get details by id using filters
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Set<Long> genre,
            @RequestParam(required = false, defaultValue = "ASC") String order) {

        List<MovieDTO> movies = this.movieService.getDetailsByFilters(title, genre, order);

        return ResponseEntity.ok(movies);
    }
}
