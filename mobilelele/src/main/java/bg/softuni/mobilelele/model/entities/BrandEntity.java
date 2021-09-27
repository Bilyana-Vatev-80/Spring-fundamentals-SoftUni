package bg.softuni.mobilelele.model.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String name;

    public BrandEntity() {
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }
}
