package com.valensmarcos.springbootdemo.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.valensmarcos.springbootdemo.entity.Publication;
import com.valensmarcos.springbootdemo.manager.PublicationManager;
import com.valensmarcos.springbootdemo.manager.TokenManager;
import com.valensmarcos.springbootdemo.manager.UserManager;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PublicationController {

    @Autowired
    TokenManager tokenManager;

    @Autowired
    UserManager userManager;

    @Autowired
    Gson gson;

    @Autowired
    PublicationManager publicationManager;

    @GetMapping("/search")
    public List<Publication> findByTitleOrContent(String search) {
        String test = "hola";
        return this.publicationManager.findAllByTitleOrContent(test);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody String jsonLogin) {
        JsonObject jsonObject = gson.fromJson(jsonLogin, JsonObject.class);
        String user = jsonObject.get("user").getAsString();
        String password = jsonObject.get("password").getAsString();
        if (userManager.validate(user, password)) {
            String token = tokenManager.createToken(user);
            return new ResponseEntity<>(token,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);}
    }
}
