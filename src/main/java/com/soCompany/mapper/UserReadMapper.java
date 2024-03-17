package com.soCompany.mapper;

import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {
    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getUsername(),
                object.getEmail(),
                object.getPassword(),
                object.getRole(),
                object.getPosts(),
                object.getFavoritePosts(),
                object.getProfilePicture(),
                object.getLikes(),
                object.isBanned(),
                object.isVerified()
        );
    }
}
