package com.boostywannabe.springproj.service;

import com.boostywannabe.springproj.models.Role;
import com.boostywannabe.springproj.models.RoleType;
import com.boostywannabe.springproj.models.User;
import com.boostywannabe.springproj.repository.RoleRepository;
import com.boostywannabe.springproj.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException(String.format("User with name %s not found", username));

        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean addUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null)
            return false;

        user.setRoles(Collections.singleton(new Role(RoleType.USER)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return true;
    }

    public void setAdmin(User user) {
        var newUser = userRepository.findByUsername(user.getUsername());
        if (newUser != null) {
            newUser.addRole(RoleType.ADMIN);
            userRepository.save(newUser);
        }
    }

    public void editUser(User user) {
        userRepository.save(user);
    }
}
