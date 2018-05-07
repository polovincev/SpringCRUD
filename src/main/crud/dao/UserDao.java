package main.crud.dao;

import main.crud.model.User;

import java.util.List;

public interface UserDao {

    public long addUser(User user);

    public void udpateUser(User user);

    public void removeUser(int id);

    public User getUser(int id);

    public List<User> listUser();

    public User getUserLogin(String name);
}
