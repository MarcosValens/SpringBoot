package com.valensmarcos.springbootdemo.repository;

import com.valensmarcos.springbootdemo.entity.Publication;

import com.valensmarcos.springbootdemo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmailAndPassword(String mail,String password);

    /*SOLO LAS CONSULTAS QUE SALGAN DE LO ESTANDARD*//*
    @Query("FROM User WHERE email=:email")
    Publication findEspecific(String email);*/

}
