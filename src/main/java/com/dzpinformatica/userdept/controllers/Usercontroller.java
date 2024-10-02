package com.dzpinformatica.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dzpinformatica.userdept.entities.User;
import com.dzpinformatica.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class Usercontroller {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public List<User> findAll() {
		List<User> result = repository.findAll();
		return result;

	}

	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}

	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {

		Optional<User> existingUserOptional = repository.findById(id);
		if (!existingUserOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		repository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

		Optional<User> existingUserOptional = repository.findById(id);
		if (!existingUserOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		User existingUser = existingUserOptional.get();

		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());

		User result = repository.save(existingUser);

		return ResponseEntity.ok(result);
	}
}
