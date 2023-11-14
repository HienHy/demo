package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAdd() {
        User user = new User();


        User saveUser = userRepository.save(user);

        Assertions.assertThat(saveUser).isNotNull();
        Assertions.assertThat(saveUser.getId()).isGreaterThan(0);

    }


    @Test
    public void testAllList() {

        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);
        for (User user : users
        ) {
            System.out.println(user);

        }


    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> userOption = userRepository.findById(userId);
        User user = userOption.get();
        user.setPassword("hahaha");
        userRepository.save(user);


        User updateUser = userRepository.findById(userId).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("hahaha");

    }

    @Test
    public void  testGet(){

        Integer userId = 3;
        Optional<User> userOption = userRepository.findById(userId);
Assertions.assertThat(userOption).isPresent();
        System.out.println(userOption.get());

    }


    @Test
    public void testDelete(){

        Integer userId = 6;
        userRepository.deleteById(userId);
        Optional<User> userOption = userRepository.findById(userId);
        Assertions.assertThat(userOption).isNotPresent();



    }






}
