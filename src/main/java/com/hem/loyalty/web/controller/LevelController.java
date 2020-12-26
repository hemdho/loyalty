package com.hem.loyalty.web.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.dto.UserTableDto;
import com.hem.auth.model.User;
import com.hem.auth.service.IUserService;
import com.hem.common.util.GenericDataTableResponse;
import com.hem.common.util.MyDateTimeFomatter;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.dto.LevelAutocompleteDto;
import com.hem.loyalty.dto.LevelDto;
import com.hem.loyalty.model.Level;
import com.hem.loyalty.repository.LevelRepository;

@CrossOrigin
@RestController
public class LevelController {
	
	@Autowired
	LevelRepository levelRepo;
	
	@Autowired
	private IUserService userService;
		
	@Autowired
	private MyDateTimeFomatter mydateTimeFormatter;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(mydateTimeFormatter.getDateFormatter(), true));
		
	}
	@GetMapping("/autocomplete/levels")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public List<LevelAutocompleteDto> getLevelsForAutocomplete(@RequestParam String companyId,@RequestParam String key) {
		List<Level> levels=levelRepo.findByName("^"+key, companyId);
		if(levels!=null && levels.size()>0) {
			return levels.stream().map(level->new LevelAutocompleteDto(level.getName(),level.getDescription())).collect(Collectors.toList());
		}
		throw new RecordNotFoundException("No Level found ");
	}
	
	@GetMapping("/admin/levels")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public GenericDataTableResponse<LevelDto> getLevels(){
		List<Level> levels=levelRepo.findAll();
		System.out.println(levels.size());
		UserTableDto userTableDto=new UserTableDto();
		GenericDataTableResponse<LevelDto> response=new GenericDataTableResponse<LevelDto>();
		response.setData(levels.stream().map(level-> new LevelDto(level)).collect(Collectors.toList()));
		response.setPage(1);
		response.setPageSize(10);
		response.setTotalPages(1);
		response.setTotalRecords(levels.size());
		return response;
		
	}
		
	@PostMapping("/admin/levels")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public Level createLevel(@RequestBody LevelDto levelDto,Principal principal) {
		levelDto.setEnabled(true);
		
		
		User user= userService.findUserByUsername(principal.getName());
		Level level= levelDto.toLevel();
		level.setUser(user);
		
		
		return levelRepo.save(level);
	}
	
}
