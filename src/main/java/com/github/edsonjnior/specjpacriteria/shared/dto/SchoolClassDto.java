package com.github.edsonjnior.specjpacriteria.shared.dto;

import java.util.Set;
import java.util.stream.Collectors;

import com.github.edsonjnior.specjpacriteria.models.SchoolClass;

import lombok.Data;

@Data
public class SchoolClassDto {
    private Long id;

    private Integer hours;

    private String room;

    private String year;

    private ProfessorDto professorDto;

    private SchoolSubjectDto schoolSubjectDto;
    
    public SchoolClassDto(SchoolClass schoolClass) {
    	this.id = schoolClass.getId();
    	this.hours = schoolClass.getHours();
    	this.room = schoolClass.getRoom();
    	this.year = schoolClass.getYear();
    	this.professorDto = ProfessorDto.convert(schoolClass.getProfessor());
    	this.schoolSubjectDto = SchoolSubjectDto.convert(schoolClass.getSchoolSubject());
    }

	public static Set<SchoolClassDto> convert(Set<SchoolClass> classes) {
		return classes.stream().map(SchoolClassDto::new).collect(Collectors.toSet());
	}



}
