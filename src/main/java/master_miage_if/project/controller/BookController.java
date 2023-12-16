package master_miage_if.project.controller;

import lombok.RequiredArgsConstructor;
import master_miage_if.project.domain.Book;
import master_miage_if.project.domain.BookRequest;
import master_miage_if.project.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping()
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping(consumes = {"application/json"})
    public Book save(@RequestBody BookRequest bookRequest) {
        return bookService.create(bookRequest);
    }
}
