package master_miage_if.project.repository;

import master_miage_if.project.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, UUID> {
    List<BookEntity> findAll();

    Optional<BookEntity> findById(UUID id);

}
