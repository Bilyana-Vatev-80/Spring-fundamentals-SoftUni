package bg.softuni.mobilelele.model.entities;

import bg.softuni.mobilelele.model.entities.enums.RoleEnum;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

    @Enumerated
    private RoleEnum name;

    public UserRole() {
    }

    public RoleEnum getName() {
        return name;
    }

    public UserRole setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
