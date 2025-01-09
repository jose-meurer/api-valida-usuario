package com.josemeurer.api.valida.usuario.service;

import com.josemeurer.api.valida.usuario.model.User;
import com.josemeurer.api.valida.usuario.repository.UserRepository;
import com.josemeurer.api.valida.usuario.repository.imp.UserRepositoryImp;
import jakarta.annotation.Resource;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServlet;

import java.util.Random;

@Resource
public class UserService extends HttpServlet {

    private UserRepository userRepository = new UserRepositoryImp();

    public void addUser(String email) {
        User user = new User(email, generateValidatorCode());

        try {
            userRepository.insert(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateValidatorCode() {
        Random random = new Random();
        return String.valueOf(100000 + random.nextInt(900000));
    }
}
