package com.github.edsonjnior.specjpacriteria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.edsonjnior.specjpacriteria.models.Student;
import com.github.edsonjnior.specjpacriteria.services.StudentService;
import com.github.edsonjnior.specjpacriteria.shared.dto.StudentDto;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public Page<StudentDto> findAll(@PageableDefault Pageable pageable) {
		Page<Student> allStudents = service.findAll(pageable);
		
		return StudentDto.convert(allStudents);
	}


}
