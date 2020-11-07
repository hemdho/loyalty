package com.hem.loyalty.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hem.auth.model.Role;
import com.hem.auth.repository.PrivilegeRepository;
import com.hem.auth.repository.RoleRepository;
import com.hem.auth.repository.UserRepository;
@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired 
	PrivilegeRepository previlegeRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		createRoleIfNotFound(new Role("Admin","Admin",new Short[]{com.hem.common.util.Privilege.createRole})); 
	}
	
	private void createRoleIfNotFound(Role role) {
		if(!roleRepo.existsById(role.getId())) roleRepo.save(role);
	}

}
