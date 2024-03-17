package com.soCompany.dto;

import com.soCompany.entity.Comment;
import com.soCompany.entity.Genre;
import com.soCompany.entity.User;

import java.util.List;

public record PostReadDto(User author,
                          String title,
                          String subtitle,
                          String content,
                          int likes,
                          List<Comment> comments) {
}
