package com.utn.ejerciciobidiuno;

import com.utn.ejerciciobidiuno.entidades.Domicilio;
import com.utn.ejerciciobidiuno.entidades.Persona;
import com.utn.ejerciciobidiuno.repositorios.DomicilioRepository;
import com.utn.ejerciciobidiuno.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EjerciciobidiunoApplication {

	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciobidiunoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo, DomicilioRepository domicilioRepo) {
		return args -> {

		};

	}
}

