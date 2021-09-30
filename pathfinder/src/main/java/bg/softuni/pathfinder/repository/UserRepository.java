package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.modul.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}