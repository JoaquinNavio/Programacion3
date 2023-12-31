package com.example.primeraAPIREST.controllers;

import com.example.primeraAPIREST.entities.Persona;
import com.example.primeraAPIREST.services.PersonaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR MALA MIA");
        }
    }
}
