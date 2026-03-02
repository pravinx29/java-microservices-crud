package com.ms.userserv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.userserv.entity.User;
import com.ms.userserv.exception.UserNotFoundException;
import com.ms.userserv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService  {

	@Autowired
	private UserRepository userRepository;
	
	@Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserById(id);
        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());
        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }

}
