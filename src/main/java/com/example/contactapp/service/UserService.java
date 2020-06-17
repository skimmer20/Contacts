package com.example.contactapp.service;

import com.example.contactapp.entity.User;
import com.example.contactapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuriismac on 2020-06-16.
 * @project contactApp
 */
@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User findById(int id){
        return userRepo.getOne(id);
    }
    public User createUser(User user){
        return userRepo.save(user);
    }
    public void deleteById(int id){
        userRepo.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

}
