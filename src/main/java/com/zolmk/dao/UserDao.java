package com.zolmk.dao;

import com.zolmk.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface UserDao {
    public List<User> list();
}
