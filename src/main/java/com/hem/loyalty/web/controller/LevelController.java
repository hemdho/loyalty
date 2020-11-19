package com.hem.loyalty.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.dto.UserTableDto;
import com.hem.common.util.GenericDataTableResponse;
import com.hem.loyalty.model.Level;
import com.hem.loyalty.repository.LevelRepository;

@CrossOrigin
@RestController
public class LevelController {
	
	@Autowired
	LevelRepository levelRepo;
	
	@GetMapping("/admin/levels")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public GenericDataTableResponse<Level> getUsers(){
		List<Level> levels=levelRepo.findAll();
		UserTableDto userTableDto=new UserTableDto();
		GenericDataTableResponse<Level> response=new GenericDataTableResponse<Level>();
		response.setData(levels);
		response.setPage(1);
		response.setPageSize(10);
		response.setTotalPages(1);
		response.setTotalRecords(levels.size());
		return response;
		
	}
		
	@PostMapping("/admin/levels")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public Level createLevel(@RequestBody Level level) {
		level.setEnabled(true);
		return levelRepo.save(level);
	}
	
}
