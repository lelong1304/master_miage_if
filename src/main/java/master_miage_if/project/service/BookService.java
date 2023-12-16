package master_miage_if.project.service;

import master_miage_if.project.domain.Book;
import master_miage_if.project.domain.BookRequest;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book create(BookRequest bookRequest);
}
