package master_miage_if.project.mapper;

import master_miage_if.project.domain.Book;
import master_miage_if.project.entity.BookEntity;

import java.util.List;

public class BookMapper {
    private BookMapper() {
    }

    public static Book toBook(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .code(bookEntity.getCode())
                .name(bookEntity.getName())
                .build();
    }

    public static List<Book> toBooks(List<BookEntity> entities) {
        return entities.stream().map(BookMapper::toBook).toList();
    }

    public static BookEntity toEntity(Book bookBuilding) {
        return BookEntity.builder()
                .name(bookBuilding.name())
                .code(bookBuilding.code())
                .build();
    }
}
