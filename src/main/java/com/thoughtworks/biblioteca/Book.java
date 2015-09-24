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

    public String bookOutput(){
        return name+" | "+author+" | "+yearPublished;
    }

    public boolean hasTitle(String title) {
        return this.name.equals(title);
    }
}
