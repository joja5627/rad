package io.rad.platfom;


import io.rad.platfom.domain.UserDocument;
import io.rad.platfom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repo.deleteAll();
		UserDocument user =
				UserDocument.builder()
					.username("admin")
					.email("admin")
					.password("admin").build();
		UserDocument admin =
				UserDocument.builder()
					.username("user")
					.email("user")
					.password("user").build();

		repo.insert(admin);
		repo.insert(user);
	}
}
