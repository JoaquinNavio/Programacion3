package com.utn.controller.controllers;

import com.utn.controller.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;

@RestController
@CrossOrigin("*")

@RequestMapping(path = "api/personas")
public class PersonaController {
    @Autowired
    private PersonRepository personaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaRepository.findById(1L));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pifiaste");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaRepository.findAll());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pifiaste lista");
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody String persona){

        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(" Te devuelvo la presona actualizada : " + persona);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        try {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body(" Eliminaste el registro : " + id );
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody String persona){

        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(" Te devuelvo la presona creada : " + persona);
        }
        catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error. Por favor intente luego\"}");
        }

    }

}
