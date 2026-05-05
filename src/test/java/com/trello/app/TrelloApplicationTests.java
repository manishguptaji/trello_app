package com.trello.app;

import com.trello.app.entity.User;
import com.trello.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class TrelloApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean
	CommandLineRunner test(UserRepository repo) {
		return args -> {
			User user = new User("test@gmail.com", "1234");
			repo.save(user);

			System.out.println(repo.findByEmail("test@gmail.com"));
		};
	}

}
