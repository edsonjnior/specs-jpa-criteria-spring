package com.github.edsonjnior.specjpacriteria.shared.dto;

import com.github.edsonjnior.specjpacriteria.models.Student;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

@Data
public class StudentDto {
    private Long id;

    private String firstName;

    private String lastName;

    private Set<SchoolClassDto> schoolClasses;

    public StudentDto(){}

    public StudentDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
    }

    public StudentDto(String firstName, String lastName) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
    }

    public StudentDto(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();

        this.schoolClasses = SchoolClassDto.convert(student.getSchoolClasses());
    }

    public static StudentDto convert(Student student) {
        return new StudentDto(student.getFirstName(), student.getLastName());
    }

    public static List<StudentDto> convert(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(Collectors.toList());
    }

	public static Page<StudentDto> convert(Page<Student> pagedStudents) {
		return pagedStudents.map(StudentDto::new);
	}
}
