package com.simplon.senForageSpringProject.dao;

import com.simplon.senForageSpringProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUser extends JpaRepository<User,Integer> {

    //Si on veux personaliser nos requette
    @Query("SELECT u FROM User u WHERE u.email=:em AND u.password=:pwd")
    public User getUserByEmailAndPassword(@Param(value = "em") String email,@Param(value = "pwd") String password);
}
