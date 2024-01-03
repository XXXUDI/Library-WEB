package com.soCompany.repo;

import com.soCompany.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String email);

    public List<User> findAllByUsername(String username);

    public Optional<User> findByUsernameOrEmail(String username, String email);
}
