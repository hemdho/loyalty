package com.hem.loyalty;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.hem.auth.model.Role;
import com.hem.auth.model.User;
import com.hem.auth.repository.RoleRepository;
import com.hem.auth.repository.UserRepository;

//@SpringBootTest
//@DirtiesContext
class LoyaltyApplicationTests {

	//@Autowired
//	RoleRepository roleRepo;
	
//	@Autowired 
//	UserRepository userRepo;
	
	@Test
	void contextLoads() {
	}
	//@Test
	public void getRole() {
	//	List<Role> roles=roleRepo.findAll();
		//assertThat(roles.size()).isEqualTo(0);
	}
	
	//@Test
	//@Transactional
	public void addUser() {
		User user = new User();
		user.setEmail("hemdho@gmail.com");
		user.setEnabled(true);
		user.setPassword("hemant");
		user.setUsername("hemant");
		user.setId("hemant");
	//	List<Role> roles= roleRepo.findAll();
		
	//	user.setRoles(roles);
		//userRepo.save(user);
		
		//List<User> users=userRepo.findAll();
		//assertThat(users.size()).isEqualTo(1);
	}
	
	 
}
