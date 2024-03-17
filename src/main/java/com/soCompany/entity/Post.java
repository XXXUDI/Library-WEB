package com.soCompany.entity;

import com.soCompany.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@AllArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    private String title;
    private String subtitle;
    @Column(columnDefinition = "TEXT")
    private String content; // Поддержка Markdown
    private int likes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;

    public Post() {
    }

    public Post(User author, String title, String subtitle, String content) {
        this.author = author;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
    }

    // Геттеры и сеттеры
}


