package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;

public class UserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of createUser method
    // Implementation must take care of the following cases:-
    // 1) Create and store user in the repository.

    public User createUser(String name) {
        User user=new User(name);
        return userRepository.save(user);
        // return user;

    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of getAllUser method
    // Implementation must take care of the following cases:-
    // 1) Get all the users in ascending Order w.r.t score.
    // 2) Get all the users in descending Order w.r.t score.

    public List<User> getUsers(UserOrder userOrder) {
        List<User> users = userRepository.findAll();
        List<User> ans;
        
        if(userOrder.toString().compareTo("ASC") == 0)
            ans = users.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());   
        else
            ans = users.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());

        return ans; 
    } 
}
