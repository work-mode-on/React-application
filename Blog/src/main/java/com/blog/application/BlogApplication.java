package com.blog.application;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.blog.application.entities.Role;
import com.blog.application.entities.User;
import com.blog.application.helper.Constant;
import com.blog.application.repositories.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.blog.application.*")
@CrossOrigin(origins = Constant.CROSS_ORIGIN)
@EnableJpaRepositories("com.blog.application.repositories")
public class BlogApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepo;

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {

		User user = new User();

		Set<Role> roles = new HashSet<>();
		roles.add(new Role("ROLE_ADMIN"));

		user.setId(1);
		user.setEmail("adi@gmail.com");
		user.setPassword(passwordEncoder.encode("qwerty@999"));
		user.setEnable(true);
		user.setName("Aditya");
		user.setRoles(roles);

		this.userRepo.save(user);

	}

}
