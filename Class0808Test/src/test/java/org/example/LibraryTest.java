package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@ExtendWith(MockitoExtension.class)
class LibraryTest {
 private   static  final Library LIBRARY =new Library();

// private    List<Book> list = new ArrayList<>();
//private static final Book BOOK1=new Book("Руслан и Людмила","Пушкин",1881) ;
//private static final Book BOOK2=new Book("Гарри Поттер","Роллинс",2001) ;
//private static final Book BOOK3=new Book("Колобок","Народ",1000) ;
////Library l =new Library(new Book("",))
//    @BeforeEach
//    void setUp(){
//        list.clear();
//        list.add(BOOK1);
//        list.add(BOOK2);
//        list.add(BOOK3);
//    }
private static final Book BOOK1 = new Book("Руслан и Людмила", "Пушкин", 1881);
    private static final Book BOOK2 = new Book("Harry Potter", "Rolling", 2001);
    private static final Book BOOK3 = new Book("Колобок", "Народные сказки", 1002);

    @BeforeEach
    void setUp() {
        Library.BOOKS.clear();
        Library.BOOKS.add(BOOK1);
        Library.BOOKS.add(BOOK2);
        Library.BOOKS.add(BOOK3);
    }

    @Test
    void addBookTest() {
//        Library.addBook(list.get(0));
//        Library.addBook(list.get(1));
//        Library.addBook(list.get(2));
//        Assertions.assertEquals(list.size(),Library.BOOKS.size());
        Library.addBook(new Book("Репка","Народные сказки", 1002));

        Assertions.assertEquals(4, Library.BOOKS.size());
    }

    @Test
    void removeBookTest() {
        Library.removeBook(BOOK1);
        Assertions.assertEquals(2, Library.BOOKS.size());
    }
    void addBookException() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            Library.addBook(null);
        });
    }
    @Test
    void searchByAuthorTest() {

            List<Book> author = Library.searchByAuthor("Пушкин");
        Assertions.assertEquals("Руслан и Людмила", author.get(0).getTitle());
        }

        @Test
        void searchByTitleTest () {
            List<Book> title = Library.searchByTitle("Руслан и Людмила");
            Assertions.assertEquals("Пушкин", title.get(0).getAuthor());
        }

        @Test
        void searchByYearTest () {
            List<Book> books = Library.searchByYear(1002);
            Assertions.assertEquals("Колобок", books.get(0).getTitle());
        }
    }

//@Test
//    void addBookException() {
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            Library.addBook(null);
//        });
//    }
//public static void addBook(Book book){
//        if (book == null){
//            throw new NullPointerException();
//        }
//        BOOKS.add(book);
//    }
