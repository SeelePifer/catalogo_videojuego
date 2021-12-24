package com.lfte.catalogo_videojuego.service;

import java.util.List;

public interface ICrud<E> {

    List<E> findAll();

    E findById(long id);

    E save(E e);
    E update(E e);

    boolean delete(long id);

}
