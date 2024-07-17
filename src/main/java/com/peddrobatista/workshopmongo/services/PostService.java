package com.peddrobatista.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peddrobatista.workshopmongo.domain.Post;
import com.peddrobatista.workshopmongo.domain.User;
import com.peddrobatista.workshopmongo.dto.UserDTO;
import com.peddrobatista.workshopmongo.repository.PostRepository;
import com.peddrobatista.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
}

