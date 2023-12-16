package master_miage_if.project.service.impl;

import lombok.RequiredArgsConstructor;
import master_miage_if.project.domain.Book;
import master_miage_if.project.domain.BookRequest;
import master_miage_if.project.entity.BookEntity;
import master_miage_if.project.mapper.BookMapper;
import master_miage_if.project.repository.BookEntityRepository;
import master_miage_if.project.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookEntityRepository bookEntityRepository;

    @Override
    public List<Book> getAll() {
        return BookMapper.toBooks(bookEntityRepository.findAll());
    }

    @Override
    public Book create(BookRequest bookRequest) {
        Book bookBuilding = Book.builder()
                .code(bookRequest.code())
                .name(bookRequest.name())
                .build();
        BookEntity entity = bookEntityRepository.save(BookMapper.toEntity(bookBuilding));
        return BookMapper.toBook(entity);
    }
}
