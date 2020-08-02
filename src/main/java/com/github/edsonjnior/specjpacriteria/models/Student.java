package com.github.edsonjnior.specjpacriteria.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Estudante
 */

@Data
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Student implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8517811226453116685L;

	@Id @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToMany(mappedBy = "students")
    private Set<SchoolClass> schoolClasses;

    public Student(){}

    public Student(String firstName, String lastName) {
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
    }
}
