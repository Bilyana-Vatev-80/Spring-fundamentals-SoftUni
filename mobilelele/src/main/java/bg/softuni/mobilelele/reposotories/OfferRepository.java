package bg.softuni.mobilelele.reposotories;

import bg.softuni.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.model.entities.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
