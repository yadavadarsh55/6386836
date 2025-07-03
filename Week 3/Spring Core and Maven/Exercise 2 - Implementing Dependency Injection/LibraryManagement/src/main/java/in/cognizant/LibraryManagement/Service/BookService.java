package in.cognizant.LibraryManagement.Service;

import in.cognizant.LibraryManagement.Repository.BookRepository;

public class BookService {
    BookRepository bookRepository;

    // Setter for Data Ingestion
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        System.out.println("BookService: Adding book...");
        bookRepository.saveBook(title);
    }
}
