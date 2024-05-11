package com.example.student.Service;

import com.example.student.dao.UserDao;
import com.example.student.dto.LoginRQ;
import com.example.student.dto.UserDTO;
import com.example.student.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserDTO getLoggedUser(LoginRQ loginRQ){
        User user = this.userDao.findByUserNameAndPassword(loginRQ.getUserName(),loginRQ.getPassword());

        UserDTO userDTO = null;

        if (user != null){
            userDTO = new UserDTO(user);
        }
        return userDTO;
    }
}
