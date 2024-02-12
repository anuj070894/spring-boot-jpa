package com.anujbrandy.data_jpa;

import com.anujbrandy.data_jpa.models.Author;
import com.anujbrandy.data_jpa.models.Video;
import com.anujbrandy.data_jpa.repositories.AuthorRepository;
import com.anujbrandy.data_jpa.repositories.VideoRepository;
import com.anujbrandy.data_jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	) {
		return args -> {
//			var author = Author
//					.builder()
//					.firstName("Anuj")
//					.lastName("Kumar")
//					.age(30)
//					.email("anujbrnwal070894@gmail.com")
//					.createdAt(LocalDateTime.now())
//					.build();
//
//			authorRepository.save(author);
//
//			var video = Video
//					.builder()
//					.length(6)
//					.name("ABC")
//					.build();
//
//			videoRepository.save(video);

			for (int i = 0; i < 50; i += 1) {
				Faker faker = new Faker();
				var author = Author
					.builder()
					.firstName(faker.name().firstName())
					.lastName(faker.name().lastName())
					.age(faker.number().numberBetween(19, 60))
					.email(faker.name().username() + "@gmail.com")
					.createdAt(LocalDateTime.now())
					.build();

				authorRepository.save(author);
			}

			var author = Author
					.builder()
					.id(1)
					.firstName("Anuj")
					.lastName("Kumar")
					.email("a@gmail.com")
					.build();

			authorRepository.save(author);
//			authorRepository.updateAllAge(150);
//			authorRepository.updateAge(100, 1);

			authorRepository.findByNamedQuery(50)
					.forEach(System.out::println);

			authorRepository.updateByNamedQuery(1000, 1);

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(30))
					.or(AuthorSpecification.firstNameContains("i"));

			System.out.println("----------Specification Example----------");
			authorRepository.findAll(spec)
					.forEach(System.out::println);
		};
	}

}
