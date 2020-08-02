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
 * Professor
 */

@Data
@Entity
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Professor implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;
	
    private String name;

    public Professor() {
    }

    public Professor(String name) {
        this.name = name.toUpperCase();
    }
    
}

