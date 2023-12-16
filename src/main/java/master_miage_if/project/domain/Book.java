package master_miage_if.project.domain;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record Book(UUID id, String name, String code, List<Student> students) {
}
