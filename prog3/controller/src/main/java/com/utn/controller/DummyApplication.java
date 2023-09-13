package com.utn.controller;

import com.utn.controller.entities.Persona;
import com.utn.controller.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DummyApplication {
@Autowired
private PersonRepository personaRepo;
	public static void main(String[] args) {
		SpringApplication.run(DummyApplication.class, args);
		System.out.println("ANDA");
	}
	@Bean
	public CommandLineRunner init() {
		return args -> {

			Persona persona = Persona.builder().nombre("pepe").apellido("nose").telefono("123").build();
			personaRepo.save(persona);

			Persona personaRecuperada = personaRepo.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("telefono: " + personaRecuperada.getTelefono());
			}



		};
	}
}
