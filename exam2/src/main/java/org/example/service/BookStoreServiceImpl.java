package org.example.service;

import org.example.models.BookForSelling;
import org.example.models.BookStore;
import org.example.models.BookType;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookStoreServiceImpl implements BookStoreService {
    @Override
    public boolean addBookToSellingReport(BookStore bookStore, BookForSelling book) {
        return bookStore.getSoldBooksReport().add(book);
    }

    @Override
    public void addBookRating(BookStore bookStore, BookForSelling book, int rating) {
        bookStore.getBooksRating().put(book, rating);
    }

    @Override
    public void printBooksInSoldBooksReport(BookStore bookStore) {
        bookStore.getSoldBooksReport()
                .stream()
                .forEach(System.out::println);
    }

    //@Override
    /* void printBooksAndRatingBooksRating(BookStore bookStore) {
        bookStore.getBooksRating()
                .entrySet()
                .stream()
                .filter(book -> book.getValue())
                .forEach(System.out.println)
    }*/

    @Override
    public Set<BookForSelling> soldBooksReportByBookForSellingBySellingPriceLessThan(BookStore bookStore, double limitPrice) {
        return bookStore.getSoldBooksReport()
                .stream()
                .filter(book -> book.getSellingPrice() < limitPrice)
                .collect(Collectors.toSet());
    }


    @Override
    public long soldBooksReportTotalQuantityByBookType(BookStore bookStore, BookType bookType) {
        return bookStore.getSoldBooksReport()
                .stream()
                .filter(bookstore -> bookstore.getBook().getBookType().equals(bookType))
                .count();
    }

   // @Override
   // public double soldBooksReportAverageSellingPrice(BookStore bookStore) {
    //    return bookStore.getSoldBooksReport()
    //            .stream()
    //}

    @Override
    public long soldBooksReportTotalSellingPriceByBookNumberOfPagesGreaterThan(BookStore bookStore, int pagesLimit) {
        return bookStore.getSoldBooksReport()
                .stream().map(report -> report.getBook())
                .filter(book -> book.getNumberOfPages() > pagesLimit)
                .reduce(0, Integer)

         }

    @Override
    public int booksRatingHighestValue(BookStore bookStore) {
        return bookStore.getBooksRating()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .max(Comparator.naturalOrder())
                .get();

    }

   // @Override
   // public Set<BookForSelling> booksRatingBooksWithHighestRating(BookStore bookStore) {
    //    return Set<e>;

}

}
