package com.valensmarcos.springbootdemo.manager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.valensmarcos.springbootdemo.entity.User;
import com.valensmarcos.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    Gson gson;

    @Autowired
    UserRepository userRepository;

    public boolean validate(String user, String password){
        return (userRepository.findByEmailAndPassword(user,password)!= null);
    }

    public User jsonToUser(String json){
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        String userString = jsonObject.get("user").getAsString();
        String pwd = jsonObject.get("password").getAsString();

        User user = new User();
        user.setEmail(userString);

        return user;
    }
}
