package bg.softuni.mobilelele.reposotories;

import bg.softuni.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.model.entities.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEnum, Long> {
}
