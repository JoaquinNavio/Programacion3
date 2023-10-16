package com.example.primeraAPIREST.controllers;

import com.example.primeraAPIREST.entities.Autor;
import com.example.primeraAPIREST.entities.Localidad;
import com.example.primeraAPIREST.services.AutorServiceImpl;
import com.example.primeraAPIREST.services.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")//permitir el acceso desde distintod origenes
@RequestMapping(path = "api/v1/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{
}
