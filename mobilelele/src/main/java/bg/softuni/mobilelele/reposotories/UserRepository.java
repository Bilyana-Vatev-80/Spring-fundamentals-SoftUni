package bg.softuni.mobilelele.reposotories;

import bg.softuni.mobilelele.model.entities.ModelEntity;
import bg.softuni.mobilelele.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
