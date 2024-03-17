package com.soCompany.dto;

import com.soCompany.entity.Post;
import com.soCompany.entity.Role;

import java.util.List;

public record UserReadDto(String username,
                          String email,
                          String password,
                          Role role,
                          List<Post> posts,
                          List<Post> favorite,
                          String image,
                          int likes,
                          boolean isBanned,
                          boolean isVerified) {

}
