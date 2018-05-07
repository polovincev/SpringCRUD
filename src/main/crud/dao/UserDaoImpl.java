package main.crud.dao;

import main.crud.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public long addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
        return user.getId();
    }

    @Override
    public void udpateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        User userdb = (User) session.load(User.class, user.getId());
        userdb.setName(user.getName());
        userdb.setPassword(user.getPassword());
        userdb.setEmail(user.getEmail());
        userdb.setRole(user.getRole());
        session.update(userdb);
    }

    @Override
    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if (user != null) {
            session.delete(user);
        }
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> listUser() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        return userList;
    }

    @Override
    public User getUserLogin(String name) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = ((User) criteria.add(Restrictions.eq("name", name)).uniqueResult());
        return user;
    }

}
