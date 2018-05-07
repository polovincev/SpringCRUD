package main.crud.service;

import main.crud.dao.UserDao;
import main.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class DBServiceImpl implements DBService {

    private final UserDao userDao;

    @Autowired
    public DBServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    @Transactional
    public long addUser(User user) {
        return this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void udpateUser(User user) {
        this.userDao.udpateUser(user);
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDao.listUser();
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserLogin(String name) {
        return this.userDao.getUserLogin(name);
    }
}
