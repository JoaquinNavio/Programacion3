package com.utn.ejer01;
import com.utn.ejer01.entidades.Persona;
import com.utn.ejer01.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ejer01Application {
	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(Ejer01Application.class, args);
	}

	@Bean
	public CommandLineRunner init(PersonaRepository personaRepo) {
		return args -> {

			System.out.println("-------------------------anda-------------------------------");
			Persona persona=new Persona();
			persona.setNombre("Juam");
			persona.setApellido("Peres");
			persona.setEdad(30);

			personaRepository.save(persona);

			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
			}

		};
	}
}










