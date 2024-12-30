package org.example.models;

import java.util.Objects;
import java.util.UUID;

public class Book implements Comparable<Book>{
    private UUID uuid;
    private String name;
    private int numberOfPages;
    private BookType bookType;
    public Book(String name, int numberOfPages, BookType bookType) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.numberOfPages = numberOfPages;
        this.bookType = bookType;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public BookType getBookType() {
        return bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", bookType=" + bookType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(uuid, book.uuid) && Objects.equals(name, book.name) && bookType == book.bookType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, numberOfPages, bookType);
    }

    @Override
    public int compareTo(Book o){
        return this.name.compareTo(o.name);
    }
}

