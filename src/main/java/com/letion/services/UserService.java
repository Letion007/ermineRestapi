package com.letion.services;

import com.letion.dao.UserDao;
import com.letion.dto.UserDTO;
import com.letion.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserDTO getByLogin(String login) {
        User user = userDao.findByLogin(login);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRegistered(user.getRegistered());
        userDTO.setRoles(user.getRoles());
        userDTO.setTotal_time_today("default");
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

}
