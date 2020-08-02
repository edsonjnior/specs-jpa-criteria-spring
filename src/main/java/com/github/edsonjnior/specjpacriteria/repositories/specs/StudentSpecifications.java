package com.github.edsonjnior.specjpacriteria.repositories.specs;

import org.springframework.data.jpa.domain.Specification;

import com.github.edsonjnior.specjpacriteria.models.Student;

public class StudentSpecifications {
	
	public static Specification<Student> firstName(String firstName){
		return (root, query, builder) -> builder.like(builder.upper(root.get("firstName")), "%" + firstName.toUpperCase() + "%");
	}
}
