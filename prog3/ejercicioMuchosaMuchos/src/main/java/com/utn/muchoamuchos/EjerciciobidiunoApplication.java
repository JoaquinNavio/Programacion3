package com.utn.muchoamuchos;
import com.utn.muchoamuchos.entidades.Domicilio;
import com.utn.muchoamuchos.entidades.Persona;
import com.utn.muchoamuchos.repositorios.DomicilioRepository;
import com.utn.muchoamuchos.repositorios.PersonaRepository;
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
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			Domicilio dom1= Domicilio.builder().calle("calle1").numero(123).build();
			Domicilio dom2= Domicilio.builder().calle("calle2").numero(456).build();
			Persona persona= Persona.builder().nombre("pepe").apellido("peron").edad(18).build();

			persona.agregarDomicilio(dom1);
			persona.agregarDomicilio(dom2);

			dom1.getPersonas().add(persona);
			dom2.getPersonas().add(persona);
			personaRepository.save(persona);

		};

	}

}

