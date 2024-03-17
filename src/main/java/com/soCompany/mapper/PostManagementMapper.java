package com.soCompany.mapper;

import com.soCompany.dto.BookManagementDto;
import com.soCompany.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostManagementMapper implements Mapper<BookManagementDto, Post> {

    @Override
    public Post map(BookManagementDto object) {
        return new Post(
                object.author(),
                object.title(),
                object.subtitle(),
                object.content()
                );
    }

    @Override
    public Post map(BookManagementDto object, Post toObject) {
        toObject.setAuthor(object.author());
        toObject.setTitle(object.title());
        toObject.setContent(object.content());
        toObject.setSubtitle(object.subtitle());
        return toObject;
    }
}
