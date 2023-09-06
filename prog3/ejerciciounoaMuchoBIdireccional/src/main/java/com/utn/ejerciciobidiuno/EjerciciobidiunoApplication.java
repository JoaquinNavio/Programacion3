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
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			Domicilio dom1= Domicilio.builder().calle("calle1").numero(123).build();
			Domicilio dom2= Domicilio.builder().calle("calle2").numero(456).build();
			Persona persona= Persona.builder().nombre("pepe").apellido("peron").edad(18).build();

			persona.agregarDomicilio(dom1);
			persona.agregarDomicilio(dom2);
			dom1.setPersona(persona);
			dom2.setPersona(persona);

			personaRepository.save(persona);

			Persona personaRecuperada= personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				personaRecuperada.mostrarDomicilio();
				System.out.println("------------------------------------------------------");
			}

			System.out.println("-------muestro la bidi---------------");
			List<Domicilio> domRecuperados=domicilioRepository.findAll();
			if (domRecuperados!=null){
				System.out.println("Domicilios");
				for (Domicilio dom:domRecuperados) {
					System.out.println("pertenece a: "+dom.getPersona().getNombre());
					System.out.println("datos: "+dom.getCalle()+" "+dom.getNumero());
				}
			}
		};

	}
}

