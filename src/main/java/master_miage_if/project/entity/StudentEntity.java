package master_miage_if.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private Integer age;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookEntity> books = new ArrayList<>();

    public void addBook(BookEntity book) {
        books.add(book);
        book.setStudent(this);
    }

    public void removeBook(BookEntity book) {
        books.remove(book);
        book.setStudent(null);
    }

}
