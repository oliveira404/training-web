package com.codigos.projetopoo.repository;

import java.util.List;

public interface IRepository<T, ID> {

    List<T> buscarTodos();
    T cadastrar(T model);
    T buscarPorId(ID id);
    boolean excluirPorId(ID id);
}
