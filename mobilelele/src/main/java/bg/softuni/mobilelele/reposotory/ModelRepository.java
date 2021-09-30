package bg.softuni.mobilelele.reposotory;

import bg.softuni.mobilelele.model.entity.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<ModelEntity, Long> {


}
