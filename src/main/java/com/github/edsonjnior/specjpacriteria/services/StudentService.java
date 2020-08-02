package com.github.edsonjnior.specjpacriteria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.edsonjnior.specjpacriteria.models.Student;
import com.github.edsonjnior.specjpacriteria.repositories.StudentRepository;
import com.github.edsonjnior.specjpacriteria.repositories.specs.StudentSpecifications;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public Page<Student> findAll(Pageable pageable){
		return repository.findAll(where(StudentSpecifications.firstName("")), pageable);
	}
}
