package com.peddrobatista.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peddrobatista.workshopmongo.domain.User;
import com.peddrobatista.workshopmongo.dto.UserDTO;
import com.peddrobatista.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource  {
	
	@Autowired
	private UserService service;
	
	//@RequestMapping(method=RequestMethod.GET) // Esse é a mesma coisa que o de baixo
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

}
