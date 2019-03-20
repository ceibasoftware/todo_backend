package com.ceiba.todo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.todo.persistence.dao.UserDao;
import com.ceiba.todo.persistence.entity.User;

@Service
public class UserService{

	@Autowired
    private UserDao userDao;

    @Transactional
    public User findUserByUserName(String userName) {
        return userDao.findUserByUsername(userName);
    }
    
    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }
}
