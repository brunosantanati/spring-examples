package com.attacomsian.jpa;

import com.attacomsian.jpa.composite.domains.Account;
import com.attacomsian.jpa.composite.domains.AccountId;
import com.attacomsian.jpa.composite.domains.Employee;
import com.attacomsian.jpa.composite.domains.EmployeeId;
import com.attacomsian.jpa.composite.repositories.AccountRepository;
import com.attacomsian.jpa.composite.repositories.EmployeeRepository;
import com.attacomsian.jpa.many2many.domains.Course;
import com.attacomsian.jpa.many2many.domains.Student;
import com.attacomsian.jpa.many2many.repositories.CourseRepository;
import com.attacomsian.jpa.many2many.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Exemplo desse tutorial: https://attacomsian.com/blog/spring-data-jpa-many-to-many-mapping
// Código no GitHub: https://github.com/attacomsian/code-examples/tree/master/spring-data-jpa/jpa-mappings

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(StudentRepository studentRepository,
                                         CourseRepository courseRepository) {
        return args -> {

            // create a student
            Student student = new Student("John Doe", 15, "8th");

            // save the student
            studentRepository.save(student);

            // create three courses
            Course course1 = new Course("Machine Learning", "ML", 12, 1500);
            Course course2 = new Course("Database Systems", "DS", 8, 800);
            Course course3 = new Course("Web Basics", "WB", 10, 0);

            // save courses
            courseRepository.saveAll(Arrays.asList(course1, course2, course3));

            // add courses to the student
            student.getCourses().addAll(Arrays.asList(course1, course2, course3));

            // update the student
            studentRepository.save(student);

            // add another course
            Course course4 = new Course("Elasticsearch", "El", 10, 1000);
            courseRepository.save(course4);
            student.getCourses().clear();
            student.getCourses().add(course4);
            studentRepository.save(student);

            // show students and courses
            studentRepository.findAll().forEach(s -> {
                System.out.println(s.getName());
                s.getCourses().forEach(c -> System.out.println("    " + c.getTitle()));
            });
        };
    }

    /*@Bean
    public CommandLineRunner mappingDemo(AccountRepository accountRepository,
                                         EmployeeRepository employeeRepository) {
        return args -> {

            // ======= `@IdClass` Annotation =======

            // create new accounts
            accountRepository.save(new Account("458666", "Checking", 4588));
            accountRepository.save(new Account("458689", "Checking", 2500));
            accountRepository.save(new Account("424265", "Saving", 100000));

            // fetch accounts by a given type
            List<Account> accounts = accountRepository.findByAccountType("Checking");
            accounts.forEach(System.out::println);

            // fetch account by composite key
            Optional<Account> account = accountRepository.findById(new AccountId("424265", "Saving"));
            account.ifPresent(System.out::println);

            // ======= `@EmbeddedId` Annotation =======

            // create new employees
            employeeRepository.save(new Employee(new EmployeeId(100L, 10L),
                    "John Doe", "john@example.com", "123456"));
            employeeRepository.save(new Employee(new EmployeeId(101L, 20L),
                    "Emma Ali", "emma@example.com", "654321"));

            // fetch employees by a given department id
            List<Employee> employees = employeeRepository.findByEmployeeIdDepartmentId(20L);
            employees.forEach(System.out::println);

            // fetch employee by composite key
            Optional<Employee> employee = employeeRepository.findById(new EmployeeId(100L, 10L));
            employee.ifPresent(System.out::println);
        };
    }*/
}
