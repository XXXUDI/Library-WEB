package com.soCompany.mapper;

public interface Mapper<F, T> {
    T map(F object);

    default T map(F object, T toObject) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
