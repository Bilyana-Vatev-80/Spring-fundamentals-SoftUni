package bg.softuni.mobilelele.reposotories;

import bg.softuni.mobilelele.model.entities.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {

    Optional<BrandEntity> findByName(String name);
}
