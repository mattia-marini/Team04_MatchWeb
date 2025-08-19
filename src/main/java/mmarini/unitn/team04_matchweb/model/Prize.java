package mmarini.unitn.team04_matchweb.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRIZE")
public class Prize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime assignedAt;

    public Prize() {
    }

    public Prize(Long id, String description, LocalDateTime asignedAt) {
        this.id = id;
        this.description = description;
        this.assignedAt = asignedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime asignedAt) {
        this.assignedAt = asignedAt;
    }
}
