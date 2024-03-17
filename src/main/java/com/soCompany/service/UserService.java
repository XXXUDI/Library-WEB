package com.soCompany.service;

import com.soCompany.dto.UserManagementDto;
import com.soCompany.dto.UserReadDto;
import com.soCompany.entity.User;
import com.soCompany.mapper.UserManagementMapper;
import com.soCompany.mapper.UserReadMapper;
import com.soCompany.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserManagementMapper userManagementMapper;
    private final UserReadMapper userReadMapper;
    private final ImageService imageService;

    // Метод для пошуку всіх користувачів (Без фільтрів)
    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream().map(userReadMapper::map).toList();
    }

    // Пошук користувачів за id
    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id).map(userReadMapper::map);
    }

    public Optional<UserReadDto> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userReadMapper::map);
    }

    public UserReadDto create(UserManagementDto dto) {
        return Optional.of(dto)
                .map(userDto -> {
                    uploadUserProfilePicture(dto.image());
                    return userManagementMapper.map(userDto);
                })
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @SneakyThrows
    private void uploadUserProfilePicture(MultipartFile image) {
        if(!image.isEmpty()) {
            imageService.uploadUserProfilePicture(image.getOriginalFilename(), image.getInputStream());
        }
    }

    public Optional<UserReadDto> update(Long id, UserManagementDto dto) {
        return userRepository.findById(id)
                .map(entity -> {
                    return userManagementMapper.map(dto, entity);
                })
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Args (Username): " + username);
        return userRepository.findByEmail(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
    }

}
