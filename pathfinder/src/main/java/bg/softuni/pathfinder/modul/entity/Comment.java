package bg.softuni.pathfinder.modul.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity{
    @Column
    private Boolean approved;
    @Column
    private Instant created;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne
    private User author;
    @ManyToOne
    private Route route;

    public Comment() {
    }

    public Boolean getApproved() {
        return approved;
    }

    public Comment setApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public Comment setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
