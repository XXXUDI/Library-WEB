package com.soCompany.dto;

import com.soCompany.entity.Role;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record UserManagementDto(String username,
                                String password,
                                String email,
                                Role role,
                                MultipartFile image,
                                boolean isBanned,
                                boolean isVerified
                                ) {
}
