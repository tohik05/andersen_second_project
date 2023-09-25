package org.example.mapper;

public interface BaseMapper<E, T, K> {

    E mapCreateToEntity(T t);

    E mapFullToEntity(K k);

    K mapToDtoFull(E e);
}
