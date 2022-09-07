package com.rajibuillt.Bookstore.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Books {

    @Id
    public Long serialNo;



    @Column(name = "title")
    public String title;

    @Column(name = "author")
    public String author;


    @Column(name = "no of pages")
    public String noOfPages;

    public Books(Long serialNo, String title, String author, String noOfPages) {
        this.serialNo = serialNo;
        this.title = title;
        this.author = author;
        this.noOfPages = noOfPages;
    }

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(String noOfPages) {
        this.noOfPages = noOfPages;
    }
}
