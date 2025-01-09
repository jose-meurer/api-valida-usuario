package com.josemeurer.api.valida.usuario.repository.imp;

import com.josemeurer.api.valida.usuario.model.User;
import com.josemeurer.api.valida.usuario.repository.UserRepository;
import jakarta.annotation.Resource;

import java.sql.*;

@Resource
public class UserRepositoryImp implements UserRepository {

    public static final String CLASS_NAME = "org.sqlite.JDBC";
    public static final String URL = "jdbc:sqlite:validatorCode.db";

    public static Connection getConnection() throws Exception{
        Class.forName(CLASS_NAME);
        return DriverManager.getConnection(URL);
    }

    @Override
    public void insert(User user) throws Exception {
        Connection con = getConnection();
        PreparedStatement state = con.prepareStatement("insert into tb_user (email, code, createAt) values(?,?,?)");
        state.setString(1, user.getEmail());
        state.setString(2, user.getCode());
        state.setTimestamp(3, new Timestamp(user.getCreateAt().toEpochMilli()));
        state.execute();
        state.close();
        con.close();
    }

    @Override
    public void createTable() {
        try{
            Connection con = getConnection();
            Statement state = con.createStatement();
            state.execute("create table if not exists tb_user(id BIGDECIMAL PRIMARY KEY AUTOINCREMENT, email TEXT NOT NULL, code TEXT, createAt TIMESTAMP)");
            state.close();
            con.close();

            /*
            * Preciso refatorar essa classe
            * 
            * Codigo exemplo de dados com tempo de validade
            * INSERT INTO eventos (descricao, expiration_time) VALUES ('Evento temporário', strftime('%s', 'now') + 900
            *
            * CREATE TRIGGER remove_expired_events AFTER INSERT ON eventos BEGIN DELETE FROM eventos WHERE expiration_time <= strftime('%s', 'now'); END;
            * */
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
