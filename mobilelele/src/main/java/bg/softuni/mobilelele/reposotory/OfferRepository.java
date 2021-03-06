package bg.softuni.mobilelele.reposotory;

import bg.softuni.mobilelele.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

    List<OfferEntity> findAll();

    Optional<OfferEntity> findById(Long id);
}
