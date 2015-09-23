package com.thoughtworks.biblioteca;

/**
 * Created by lsantano on 9/22/15.
 */
public class Book {

    private String name;
    private String author;
    private Integer yearPublished;

    public Book(String name, String author, Integer yearPublished){
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String toString(){
        return name+" "+author+" "+yearPublished;
    }
}
