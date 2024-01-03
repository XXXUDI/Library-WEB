package com.soCompany.mapper;

import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.User;
import com.soCompany.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper implements Mapper<UserReadDto, User>{

    private final UserRepository repository;
    @Override
    public User map(UserReadDto object) {
        return repository.findByUsernameOrEmail(object.login, object.login).orElse(null);
    }
}
