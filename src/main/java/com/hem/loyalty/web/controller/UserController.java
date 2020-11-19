package com.hem.loyalty.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.dto.UserDto;
import com.hem.auth.dto.UserTableDto;
import com.hem.auth.model.User;
import com.hem.auth.repository.UserRepository;
import com.hem.auth.service.IUserService;
import com.hem.common.util.GenericDataTableResponse;
import com.hem.exception.RecordNotFoundException;
@CrossOrigin
@RestController
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/admin/users")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public User createUser( @RequestBody UserDto user) {
	//	user.getRoles().forEach(role->System.out.println(role.getName()));
		return userService.registerNewUserAccount(user);
	}
	
	@GetMapping("/admin/users")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public GenericDataTableResponse<UserTableDto> getUsers(){
		List<User> users=userRepo.findAll();
		UserTableDto userTableDto=new UserTableDto();
		GenericDataTableResponse<UserTableDto> response=new GenericDataTableResponse<UserTableDto>();
		response.setData(userTableDto.getUserTableDtoList(users));
		response.setPage(1);
		response.setPageSize(10);
		response.setTotalPages(1);
		response.setTotalRecords(users.size());
		return response;
		
	}
	
	@GetMapping("/admin/users/{id}")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public UserTableDto getUser(@PathVariable("id") String id){
		Optional<User> user=userRepo.findById(id);
		if(user.isPresent()) return new UserTableDto().getUserTableDto(user.get());
		throw new RecordNotFoundException("User not found");
	}
	
	
}
