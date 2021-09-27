package bg.softuni.mobilelele.model.entities;

import bg.softuni.mobilelele.model.entities.enums.UserRoleEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class UserRoleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum name;

    public Long getId() {
        return id;
    }

    public UserRoleEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getName() {
        return name;
    }

    public UserRoleEntity setName(UserRoleEnum name) {
        this.name = name;
        return this;
    }
}
