package com.springboot;

import com.springboot.entity.Book;
import com.springboot.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Spliterator;

@SpringBootTest
class SpringbootEsApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        Book book = new Book();
        book.setId(1);
        bookRepository.save(book);
    }

    @Test
    void query(){
        Iterable<Book> all = bookRepository.findAll();

        System.out.println(all.iterator());
    }
}
