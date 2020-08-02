package com.github.edsonjnior.specjpacriteria.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Matéria/Disciplina
 */

@Data
@Entity
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class SchoolSubject implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7002148788955289058L;

	@Id @GeneratedValue
    private Long id;

    private String name;

    public SchoolSubject() {
    }

    public SchoolSubject(String name) {
        this.name = name.toUpperCase();
    }
}
