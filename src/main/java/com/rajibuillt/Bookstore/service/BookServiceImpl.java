package com.rajibuillt.Bookstore.service;

import com.rajibuillt.Bookstore.entity.Books;
import com.rajibuillt.Bookstore.repository.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BooksRepository booksRepository;

    private BookService bookService;

    public BookServiceImpl() {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Books> findAll() {
        return bookService.findAll();
    }

    @Override
    public Books findById(int serialNo) {

        Optional<Books> result = booksRepository.findById((int) serialNo);

        Books books = null;

        if (result.isPresent())
            books = result.get();
        else
            throw new RuntimeException("Did not find Book serialNo :" + serialNo);
        return books;
    }

    @Override
    public void save(Books books) {
        booksRepository.save(books);
    }

    @Override
    public void deleteById(int serialNo) {
        booksRepository.deleteById((int) serialNo);
    }

    @Override
    public Books findBySerialNo(int serialNo) {
        return null;
    }


}

