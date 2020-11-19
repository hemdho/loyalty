package com.hem.loyalty.web.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.dto.RoleDto;
import com.hem.auth.model.Role;
import com.hem.auth.repository.RoleRepository;
@CrossOrigin
@RestController
public class RoleController {

	@Autowired
	RoleRepository roleRepo;
	
	@PostMapping("/admin/roles")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public Role createRole(@RequestBody RoleDto roleDto) {
		Role role= new Role();
		role.setId(roleDto.getName());
		role.setName(roleDto.getName());
		role.setEnabled(true);
		Set<Short> privileges=new HashSet<Short>();
		roleDto.getPrivilege().forEach(p->privileges.add(p));
		role.setPrivileges(privileges);
		role=roleRepo.save(role);
		return role;
	}
	@GetMapping("/admin/roles")
	@ResponseBody
	
	@ResponseStatus(value=HttpStatus.OK)
	public List<Role> getRoles(){
		return roleRepo.findAll();
	}
}