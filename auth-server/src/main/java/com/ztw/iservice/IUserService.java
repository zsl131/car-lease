package com.ztw.iservice;

import com.ztw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by zsl-pc on 2016/8/31.
 */
public interface IUserService extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
