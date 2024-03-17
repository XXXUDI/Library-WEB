package com.soCompany.mapper;

import com.soCompany.dto.PostReadDto;
import com.soCompany.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostReadMapper implements Mapper<Post, PostReadDto>{
    @Override
    public PostReadDto map(Post object) {
        return new PostReadDto(
                object.getAuthor(),
                object.getTitle(),
                object.getSubtitle(),
                object.getContent(),
                object.getLikes(),
                object.getComments()
                );
    }
}
