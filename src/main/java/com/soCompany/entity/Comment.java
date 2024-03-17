package com.soCompany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    @Column(columnDefinition = "TEXT")
    private String content; // Поддержка Markdown

    public Comment() {
    }

    public Comment(User author, Post post, String content) {
        this.author = author;
        this.post = post;
        this.content = content;
    }

    // Геттеры и сеттеры
}