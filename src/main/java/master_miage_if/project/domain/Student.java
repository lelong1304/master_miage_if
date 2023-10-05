package master_miage_if.project.domain;

import lombok.Builder;

import java.util.UUID;

@Builder
public record Student(
        UUID id,
        String firstName,
        String lastName,
        String email,
        Integer age) {
}