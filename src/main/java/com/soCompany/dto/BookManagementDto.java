package com.soCompany.dto;

import com.soCompany.entity.User;

public record BookManagementDto(User author,
                                String title,
                                String subtitle,
                                String content) {
}
