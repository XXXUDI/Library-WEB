package com.soCompany.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Entity
@AllArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_favorite_posts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> favoritePosts;
    private String profilePicture;
    private int likes;
    private boolean isBanned;
    private boolean isVerified;

    public User() {

    }

    public User(String username, String password, String email, Role role, boolean banned, boolean verified) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.isBanned = banned;
        this.isVerified = verified;
    }
}


