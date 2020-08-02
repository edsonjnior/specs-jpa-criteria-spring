package com.github.edsonjnior.specjpacriteria.shared.dto;

import com.github.edsonjnior.specjpacriteria.models.SchoolSubject;

import lombok.Data;

@Data
public class SchoolSubjectDto {

	private Long id;
	private String name;

	public SchoolSubjectDto(SchoolSubject schoolSubject) {
		this.id = schoolSubject.getId();
		this.name = schoolSubject.getName();
	}

	public static SchoolSubjectDto convert(SchoolSubject schoolSubject) {
		return new SchoolSubjectDto(schoolSubject);
	}
}
