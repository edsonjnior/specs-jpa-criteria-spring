package com.github.edsonjnior.specjpacriteria;

import com.github.edsonjnior.specjpacriteria.models.SchoolClass;
import com.github.edsonjnior.specjpacriteria.models.Professor;
import com.github.edsonjnior.specjpacriteria.models.SchoolSubject;
import com.github.edsonjnior.specjpacriteria.models.Student;
import com.github.edsonjnior.specjpacriteria.repositories.ProfessorRepository;
import com.github.edsonjnior.specjpacriteria.repositories.SchoolClassRepository;
import com.github.edsonjnior.specjpacriteria.repositories.SchoolSubjectRepository;
import com.github.edsonjnior.specjpacriteria.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpecJpaCriteriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecJpaCriteriaApplication.class, args);
    }

    @Component
    class Initializer implements ApplicationRunner {
        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private ProfessorRepository professorRepository;

        @Autowired
        private SchoolClassRepository schoolClassRepository;

        @Autowired
        private SchoolSubjectRepository schoolSubjectRepository;

        @Override
        public void run(ApplicationArguments args) {
            List<Student> students = studentRepository.saveAll(
                    Arrays.asList(
                            new Student("Edson", "Júnior"),
                            new Student("Dorilene", "Nascimento"),
                            new Student("Miguel", "eduardo")
                    )
            );

            Professor rogerio = new Professor("Rogério Batista");
            professorRepository.save(rogerio);

            SchoolSubject oop = new SchoolSubject("OOP - Object Oriented Programming");
            schoolSubjectRepository.save(oop);

            SchoolClass turmaOOPInformatica = new SchoolClass("B2-10", "2020.1", 90, rogerio, oop);
            turmaOOPInformatica.getStudents().addAll(students);
            schoolClassRepository.save(turmaOOPInformatica);


        }
    }
}

