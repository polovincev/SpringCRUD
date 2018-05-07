package main.crud.service;

import main.crud.model.User;

import java.util.List;

public interface DBService {

    public long addUser(User user);

    public void udpateUser(User user);

    public User getUser(int id);

    public List<User> listUser();

    public void removeUser(int id);

    public User getUserLogin(String name);
}

