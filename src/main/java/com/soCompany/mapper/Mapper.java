package com.soCompany.mapper;

public interface Mapper<F, T> {
    T map(F object);
}
