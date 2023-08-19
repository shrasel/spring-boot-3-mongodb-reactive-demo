package com.ngs.reactive.reactive;

import com.github.javafaker.Faker;
import com.ngs.reactive.reactive.Student.Student;
import com.ngs.reactive.reactive.Student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService){
		Faker faker = new Faker();
		return args -> {
			for (int i = 0; i < 100; i++) {
				studentService.save(Student.builder()
						.studentId(faker.random().nextInt(100000,2000000))
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.random().nextInt(16,45))
						.gender(faker.demographic().sex())
						.build()).subscribe();
			}
		};
	}

}
