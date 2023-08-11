package org.example;
//String title - название книги.
//String author - автор книги.
//int year - год издания книги.
public class Book
{
    String title;
    String author;
    int year;

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }


    public String getAuthor() {
        return author;
    }


    public int getYear() {
        return year;
    }


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
