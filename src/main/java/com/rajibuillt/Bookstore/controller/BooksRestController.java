package com.rajibuillt.Bookstore.controller;

import com.rajibuillt.Bookstore.entity.Books;
import com.rajibuillt.Bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/books/")
public class BooksRestController {


    @Autowired
    private BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("signup")
    public String showSignUpForm(Books books) {
        return "add-books";
    }



    @GetMapping("/list")
    public String findAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }


    @GetMapping("/books/{serialNo}")
    public String getBooksById(@PathVariable("serialNo") int serialNo, Model model) {
        Books books = bookService.findBySerialNo(serialNo);
        if (books == null) {
            throw new RuntimeException("Book with entered serialNo not found -" + serialNo);
        }
        model.addAttribute("books", books);
        return "update-books";
    }


    @PostMapping("add")
    public String addBook(@Valid Books books, BindingResult result, Model model) {
        if (books.getSerialNo() == 0)
            throw new RuntimeException("Please enter a serial number");
        int length = String.valueOf(books.getSerialNo()).length();
        boolean numeric = true;
        try {
            Double num = Double.parseDouble(String.valueOf(books.getSerialNo()));
        } catch (NumberFormatException e) {
            numeric = false;
        }
        if (!numeric)
            bookService.save(books);
        return "add-books";
    }


    @GetMapping("delete/{serialNo}")
    public String deleteBooks(@PathVariable("serialNo") int serialNo, Model model) {
        Books tempBook = bookService.findBySerialNo(serialNo);
        if (tempBook == null) {
            throw new RuntimeException("Book with this serialNo not found -" + serialNo);
        }
        bookService.deleteById(serialNo);
        return "index";
    }

}
