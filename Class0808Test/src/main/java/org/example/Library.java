package org.example;

import java.util.ArrayList;
import java.util.List;

//Класс Library:
//Поля:
//List<Book> books - список книг в библиотеке.
//
//Методы:
//
//void addBook(Book book) - добавляет книгу в список книг библиотеки.
//void removeBook(Book book) - удаляет книгу из списка книг библиотеки.
//List<Book> searchByAuthor(String author) - возвращает список книг по заданному автору.
//List<Book> searchByTitle(String title) - возвращает список книг по заданному названию.
//List<Book> searchByYear(int year) - возвращает список книг по заданному году издания.
public class Library {
    public static final List<Book> BOOKS =new ArrayList<>() ;

    public Library() {
    }

    public static void addBook(Book book){
    if (book == null){
        throw new NullPointerException();
    }
        BOOKS.add(book);
    }
   public static void removeBook(Book book){
        BOOKS.remove(book);
   }
   public static List<Book> searchByAuthor(String author){
       return BOOKS.stream()
               .filter(el -> el.getAuthor().equals(author))
               .toList();

   }
    public static List<Book> searchByTitle(String title){
        return BOOKS.stream()
                .filter(el -> el.getTitle().equals(title))
                .toList();

    }
    public static List<Book> searchByYear(int year){
        return BOOKS.stream()
                .filter(el -> el.getYear()==(year))
                .toList();

    }
}
