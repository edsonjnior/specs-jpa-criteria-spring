package com.github.edsonjnior.specjpacriteria.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Turma
 */

@Data
@Entity
@ToString
@AllArgsConstructor
public class SchoolClass implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1817311831559591133L;

	@Id
    @GeneratedValue
    private Long id;

    private Integer hours;

    private String room;

    private String year;

    @ManyToOne
    private Professor professor;

    @OneToOne
    private SchoolSubject schoolSubject;

    @ManyToMany
    @JoinTable(
            name = "school_class_student",
            joinColumns = @JoinColumn(name = "school_class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();


    public SchoolClass() {
    }

    public SchoolClass(String room, String year, Integer hours, Professor professor, SchoolSubject schoolSubject){
        this.room = room;
        this.year = year;
        this.hours = hours;
        this.professor = professor;
        this.schoolSubject = schoolSubject;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolClass other = (SchoolClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
    
    
}
