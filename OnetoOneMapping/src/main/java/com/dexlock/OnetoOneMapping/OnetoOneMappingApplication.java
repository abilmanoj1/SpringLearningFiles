package com.dexlock.OnetoOneMapping;

import com.dexlock.OnetoOneMapping.entity.Gender;
import com.dexlock.OnetoOneMapping.entity.User;
import com.dexlock.OnetoOneMapping.entity.UserProfile;
import com.dexlock.OnetoOneMapping.repository.UserProfileRepository;
import com.dexlock.OnetoOneMapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OnetoOneMappingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnetoOneMappingApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;


	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Abil");
		user.setEmail("abilmanoj1@gmail.com");

		UserProfile userProfile = new UserProfile();
		userProfile.setAddress("Kochi");
		userProfile.setBirthDate(LocalDate.of(1998,04,05));
		userProfile.setGender(Gender.MALE);
		userProfile.setPhoneNumber("9961494446");

		user.setUserProfile(userProfile);
		userProfile.setUser(user);

		userRepository.save(user);
	}
}
