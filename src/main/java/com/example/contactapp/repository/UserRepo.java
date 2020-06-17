package com.example.contactapp.repository;

import com.example.contactapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuriismac on 2020-06-16.
 * @project contactApp
 */
public interface UserRepo extends JpaRepository<User, Integer> {
}
