package com.example.data.bootstrap;

import com.example.data.domain.Address;
import com.example.data.domain.Card;
import com.example.data.domain.Faculty;
import com.example.data.domain.Student;
import com.example.data.repositories.FacultyRepository;
import com.example.data.services.FacultyService;
import com.example.data.services.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final StudentService studentService;
    private final FacultyService facultyService;

    public DataLoader(StudentService studentService, @Qualifier("facultyServiceEm") FacultyService facultyService, FacultyRepository facultyRepository) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @Override
    public void run(String... args) throws Exception {
        Address a1 = new Address("Bucharest");
        Student s1= new Student("John",a1);
        Card c1=new Card("123");
        Card c2=new Card("234");
        s1.addCard(c1);
        s1.addCard(c2);
        Faculty fils = new Faculty("FILS");
        fils.addStudent(s1);
        facultyService.save(fils);
        List<Faculty> faculties = facultyService.findFacultiesByName("FILS");
        System.out.println("\n\n\n\n\n");
        faculties.forEach(System.out::println);
        System.out.println("\n\n\n\n\n");
    }
}
