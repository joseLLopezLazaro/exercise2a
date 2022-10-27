package com.example.exercise2;

import com.example.exercise2.entities.Laptop;
import com.example.exercise2.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Exercise2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Exercise2Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		// crear laptop
		Laptop laptop = new Laptop(null,"Lenovo",1109.87, LocalDate.of(2020,11,05));
		Laptop laptop2 = new Laptop(null,"HP",1409.87,LocalDate.of(2021,10,05));
		Laptop laptop3 = new Laptop(null,"LG",809.87,LocalDate.of(2018,12,25));


		// almacenar un laptop
		System.out.println("Num Laptop: " + repository.findAll().size());
		repository.save(laptop);
		repository.save(laptop2);
		repository.save(laptop3);

		// recuperar todos los laptop
		System.out.println("Num Laptop: " + repository.findAll().size());

		// borrar un laptop
//			repository.deleteById(1L);
//			System.out.println("Num Laptop: " + repository.findAll().size());
	}

}

