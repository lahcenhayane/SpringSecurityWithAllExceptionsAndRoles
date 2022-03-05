package com.project.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.app.Models.Address;
import com.project.app.Models.Role;
import com.project.app.Models.User;
import com.project.app.Repositories.RoleRepository;
import com.project.app.Repositories.UserRepository;
import com.project.app.Services.IRoleService;
import com.project.app.Services.IUserService;

@SpringBootApplication
public class TestAppCrud2Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestAppCrud2Application.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		if (roleRepository.count() <= 0) {
			Role admin = new Role();
			admin.setName("Admin");
			
			Role client = new Role();
			client.setName("Client");
			
			roleRepository.saveAll(List.of(admin, client));
		}
		if (userRepository.count() <= 0) {
			
			Address address = Address.builder()
									.address1("Hay Pam 1")
									.pays("Maroc")
									.city("Oulmes")
									.zipCode("15100")
									.build();
			
			User user = new User();
			user.setEmail("lahcenhayane@gmail.com");
			user.setName("Lahcen HAYANE");
			user.setBirthDay(new SimpleDateFormat("yyyy-MM-dd").parse("1997-06-17"));
			user.setPassword(passwordEncoder().encode("lahcenhayane"));
			user.setAddress(address);
			
			user = userRepository.save(user);
			
			Role role = roleRepository.findByName("Admin");
			
			user.getRoles().add(role);
			userRepository.save(user);
			
		}
	}

}
