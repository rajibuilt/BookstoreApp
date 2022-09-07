package com.rajibuillt.Bookstore.repository;

import com.rajibuillt.Bookstore.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {

}
