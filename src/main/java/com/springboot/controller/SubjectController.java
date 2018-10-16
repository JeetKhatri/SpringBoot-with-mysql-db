package com.springboot.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Subject;
import com.springboot.service.SubjectService;

/***
 * 
 * @author Jeet Khatri
 * @date 15-Oct-2018
 * @link https://github.com/JeetKhatri/SpringBoot-with-mysql-db.git
 *
 */

@RestController
/*@RequestMapping("/api")*/
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome to the subject app";
	}
	
	@GetMapping("/subjects")
	public List<Subject> listOfSubjects() {
		return subjectService.getListOfSubjects();
	}
	
	@PostMapping("/subjects")
	public Subject addSubject(@Valid @RequestBody Subject subject) {
		return subjectService.addSubject(subject);
	}
	
	@PutMapping("/subjects/{id}")
	public Subject updateSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
		return subjectService.updateSubject(subject,id);
	}
	
	/*
	 * Two way to get variable from url
	 * 1.	@PathVariable int id  (same name required in getMapping)
	 * 2.	@PathVariable(name="id") int subjectId (can use different name)
	 * 
	 */
	@GetMapping("/subjects/{id}")
	public Subject getSubject(@PathVariable(name="id") int subjectId) {
		return subjectService.getSubject(subjectId);
	}
	
	@DeleteMapping("/subjects/{id}")
	public ResponseEntity<?> deleteSubject(@PathVariable int id) {
		return subjectService.deleteSubject(id);
	}
	
}
