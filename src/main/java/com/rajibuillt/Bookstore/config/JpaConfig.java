package com.rajibuillt.Bookstore.config;

import com.rajibuillt.Bookstore.service.BookService;
import com.rajibuillt.Bookstore.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;

public class JpaConfig {
    @Bean("bookService")
    public BookService bookService(){
        return new BookServiceImpl();
    }

}
