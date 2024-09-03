package com.scm.scm20.services.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.id.uuid.UuidGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.scm20.entities.User;
import com.scm.scm20.helpers.ResourceNotFoundException;
import com.scm.scm20.repositories.UserRepo;
import com.scm.scm20.services.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger  logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        // 1.Generate unique userId 
            // and 2.Encode Password
        String userId = UUID.randomUUID().toString(); 
        user.setUserId(userId);
        // String password = 
        // user.setPassword(password);
        // default profile pic-url
        // user.setProfilePic(profilePic);
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("User not found"));
        // user2 is from db, to update user2 from -> user

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        // save updated user2 in the db
        User save = userRepo.save(user2);

        return Optional.ofNullable(save);        //if user->(save) is null it will return "empty" else it'll return user2.
    }


    @Override
    public void deleteUser(String id) {

        logger.info("Deleting user");
        // fetch user by id
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
        // the orElseThrow() -> will return an value(User object) or throw an exception if the user is not found
        userRepo.delete(user);

        logger.debug("User deleted successfully");
    }

    @Override
    public boolean doesUserExist(String userId) {
        User user = userRepo.findById(userId).orElse(null);

        return user != null;
    }

    @Override
    public boolean doesUserExistByEmail(String email) {
         /**
     * Checks if a user exists in the database by email.
     *
     * @param  email  the email of the user to check
     * @return        true if a user with the given email exists, false otherwise
     */
        User user = userRepo.findByEmail(email).orElse(null);           

        return user != null;    
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


}
