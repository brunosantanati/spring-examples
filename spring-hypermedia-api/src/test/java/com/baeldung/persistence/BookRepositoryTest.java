package com.baeldung.persistence;

import com.baeldung.SpringHypermediaApiApplication;
import com.baeldung.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringHypermediaApiApplication.class)
@WebAppConfiguration
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void persisting() {
        Book book1 = new Book();
        book1.setAuthor("Author1");
        book1.setTitle("Title1");
        book1.setIsbn(UUID.randomUUID().toString());
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAuthor("Author2");
        book2.setTitle("Title2");
        book2.setIsbn(UUID.randomUUID().toString());
        bookRepository.save(book2);

    }
}
