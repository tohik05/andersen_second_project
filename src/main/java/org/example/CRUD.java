package org.example;

import java.util.List;

public interface CRUD<E> {

    E getById(Long id);

    List<E> getAll();

    E create(E e);

    E update(E e);

    boolean deleteById(Long id);
}
