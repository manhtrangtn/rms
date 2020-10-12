package com.t1809e.rms;

import com.t1809e.rms.entity.User;
import com.t1809e.rms.entity.UserRole;
import com.t1809e.rms.repository.UserRepository;
import com.t1809e.rms.repository.UserRoleRepository;
import com.t1809e.rms.utility.constance.RoleStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class RmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RmsApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		UserRole role = new UserRole();
		role.setName("ROLE_ADMIN");
		role.setStatus(RoleStatus.ACTIVE);
		userRoleRepository.save(role);

		User user = new User();
		user.setFirstName("System");
		user.setLastName("Administrator");
		user.setBirthDay(LocalDate.now());
		user.setGender("Male");
		user.setRole(role);
//		user.setCreatedAt(LocalDateTime.now());
		user.setStatus("Active");
		user.setUsername("admin");
		user.setId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode("admin"));

		userRepository.save(user);
		System.out.println(user);
	}
}
