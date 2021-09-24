package bg.softuni.mobilelele.reposotories;

import bg.softuni.mobilelele.model.entities.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
}
