package com.soCompany.mapper;

import com.soCompany.dto.UserManagementDto;
import com.soCompany.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserManagementMapper implements Mapper<UserManagementDto, User> {

    @Override
    public User map(UserManagementDto object) {
        return new User(
                object.username(),
                object.password(),
                object.email(),
                object.role(),
                object.isBanned(),
                object.isVerified()
        );
    }

    @Override
    public User map(UserManagementDto object, User toObject) {
        toObject.setUsername(object.username());
        toObject.setEmail(object.email());
        toObject.setRole(object.role());
        toObject.setPassword(object.password());
        toObject.setBanned(object.isBanned());
        toObject.setVerified(object.isVerified());

        Optional.ofNullable(object.image())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image -> toObject.setProfilePicture(image.getOriginalFilename()));
        return toObject;
    }
}
