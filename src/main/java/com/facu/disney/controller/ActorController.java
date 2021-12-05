package com.facu.disney.controller;

import com.facu.disney.dto.ActorBasicDTO;
import com.facu.disney.dto.ActorDTO;
import com.facu.disney.service.ActorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    ActorService actorService;

    //save actor
    @PostMapping
    public ResponseEntity<ActorDTO> save(@RequestBody ActorDTO actor) {

        ActorDTO actorSaved = this.actorService.save(actor);

        return ResponseEntity.status(HttpStatus.CREATED).body(actorSaved);
    }

    //basic actors list
    @GetMapping("/characters")
    public ResponseEntity<List<ActorBasicDTO>> getBasic() {

        List<ActorBasicDTO> actors = this.actorService.getBasic();

        return ResponseEntity.ok().body(actors);
    }
    
    //update actor
    @PutMapping("/{idActor}")
    public ResponseEntity<ActorDTO> update(@RequestBody ActorDTO actor, @PathVariable Long idActor){
        
        ActorDTO actorUpdated = this.actorService.update(actor, idActor);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(actorUpdated);
    }
    
    //delete actor
    @DeleteMapping("/{idActor}")
    public ResponseEntity<Void> detele(@PathVariable Long idActor){
        
        this.actorService.delete(idActor);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    //get details by idActor
    @GetMapping("/{idActor}")
    public ResponseEntity<ActorDTO> getDetailsById(@PathVariable Long idActor){
        
        ActorDTO actorById = this.actorService.getDetailsById(idActor);
        
        return ResponseEntity.ok(actorById);
    }
}
