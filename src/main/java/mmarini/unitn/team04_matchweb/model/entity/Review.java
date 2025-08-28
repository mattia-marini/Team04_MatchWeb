package mmarini.unitn.team04_matchweb.model.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // username is a foreign key to USERS.username
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private int rating; // 1–5

    @Column(length = 1024)
    private String text;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Review() {
    }

    public Review(String username, int rating, String text) {
        this.username = username;
        this.rating = rating;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
