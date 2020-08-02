package com.github.edsonjnior.specjpacriteria.shared.dto;

import com.github.edsonjnior.specjpacriteria.models.Professor;

import lombok.Data;

@Data
public class ProfessorDto {
    private Long id;

    private String name;
    
    
    public ProfessorDto(Long id, String name) {
    	super();
    	this.id = id;
    	this.name = name;
    }

    public ProfessorDto(Professor professor) {
    	this.id = professor.getId();
    	this.name = professor.getName();
    }
    
	public static ProfessorDto convert(Professor professor) {
		return new ProfessorDto(professor);
	}
}
