package com.t1809e.rms.service;

import com.t1809e.rms.entity.User;
import com.t1809e.rms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String id){
        return userRepository.getUserById(id);
    }

    public List<User> getUsers(String keyword){
        keyword = "%" + keyword + "%";
        return userRepository.fullTextSearchh(keyword);
    }

    public void saveUser(User user , String departmentId){

        userRepository.save(user);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String id){
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public void addUserToDepartment(String userId, String departmentId){
        User user = userRepository.findById(userId).get();
        userRepository.save(user);
    }

    public void deleteUserFromDepartment(String userId, String departmentId){
        User user = userRepository.findById(userId).get();
        userRepository.save(user);
    }
}
