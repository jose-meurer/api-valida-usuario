package com.josemeurer.api.valida.usuario.repository;

import com.josemeurer.api.valida.usuario.model.User;

public interface UserRepository {

    void insert(User user) throws Exception;

    void createTable()throws Exception;
}
