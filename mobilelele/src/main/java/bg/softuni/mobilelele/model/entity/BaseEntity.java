package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected Instant created;
    @Column(nullable = false)
    protected Instant modified;

    @PrePersist
    public void prePersist(){
        setCreated(Instant.now());
        setModified(Instant.now());
    }

    public BaseEntity() {
    }

    @PreUpdate
    public void preUpdate(){
        setModified(Instant.now());
    }

    public Long getId() {
        return id;
    }

    public BaseEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BaseEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}
