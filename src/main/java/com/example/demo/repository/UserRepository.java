package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);


    public Long countById(Integer id); 
}
