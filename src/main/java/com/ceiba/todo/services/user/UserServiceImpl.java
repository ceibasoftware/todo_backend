package com.ceiba.todo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.todo.persistence.dao.UserDao;
import com.ceiba.todo.persistence.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User findUserByUserName(String userName) {
        return userDao.findUserByUsername(userName);
    }
    
    @Override
    @Transactional
    public User create(User user) {
        return userDao.save(user);
    }
}
