package master_miage_if.project.domain;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record Student(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Integer age,
        List<Book> books) {
}