package com.example.emailsys.emailsys.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.emailsys.emailsys.model.Email;
import com.example.emailsys.emailsys.repository.EmailRepository;

@RestController
@RequestMapping("/api")
public class EmailController {

	@Autowired
	EmailRepository emailRepository;
	
	@GetMapping("/emails")
	public List<Email> getAllEmails(){
		return emailRepository.findAll();
	}
	
	@GetMapping("/emails/{id}")
	public Email getEmailById(
			@PathVariable(value="id") Long EmailId) {
		return emailRepository.findById(EmailId)
				.orElseThrow(() -> new RuntimeException("Email By ID Exc"));
	}
	
	@PostMapping("/emails")
	public Email AddEmail(@Valid @RequestBody Email email) {
		return emailRepository.save(email);
	}
	
	@PutMapping("/emails/{id}")
	public Email UpdateEmail(@PathVariable(value="id")
			Long EmailId, @Valid @RequestBody Email emailDetails) {
		
		Email email = emailRepository.findById(EmailId)
				.orElseThrow(()->new RuntimeException("Not Found"));
		email.setSubject(emailDetails.getSubject());
		email.setContent(emailDetails.getContent());
		Email UpdatedEmail = emailRepository.save(email);
		return UpdatedEmail;
		
	}
	
	@DeleteMapping("/emails/{id}")
	public ResponseEntity<?> DeleteEmail(
			@PathVariable(value="id") Long EmailId){
		Email email = emailRepository.findById(EmailId)
				.orElseThrow(()->new RuntimeException("Not Found"));
		emailRepository.delete(email);
		return ResponseEntity.ok().build();
	}
	
	
	
	
}
