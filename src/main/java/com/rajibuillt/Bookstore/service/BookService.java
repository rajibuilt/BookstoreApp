package com.rajibuillt.Bookstore.service;

import com.rajibuillt.Bookstore.entity.Books;

import java.util.List;


public interface BookService {


    public List<Books> findAll();


    Books findById(int serialNo);

    public void save(Books books);

    public void deleteById(int serialNo);



    Books findBySerialNo(int serialNo);
}
