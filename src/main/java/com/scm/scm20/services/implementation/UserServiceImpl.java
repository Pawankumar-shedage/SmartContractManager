// package com.scm.scm20.services.implementation;

// import java.util.List;
// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.scm.scm20.entities.User;
// import com.scm.scm20.repositories.UserRepo;
// import com.scm.scm20.services.UserService;

// @Service
// public class UserServiceImpl implements UserService {

//     @Autowired
//     private UserRepo userRepo;

//     private Logger  logger = LoggerFactory.getLogger(this.getClass());

//     @Override
//     public User saveUser(User user) {
//         return userRepo.save(user);
//     }

//     @Override
//     public Optional<User> getUserById(String id) {
//         return userRepo.findById(id);
//     }

//     @Override
//     public Optional<User> updateUser(User user) {
//         return userRepo.save(user);
//     }

//     @Override
//     public void deleteUser(String id) {
        
//     }

//     @Override
//     public boolean doesUserExist(String userId) {
        
//     }

//     @Override
//     public boolean doesUserExistByEmail(String email) {
        
//     }

//     @Override
//     public List<User> getAllUsers() {
        
//     }


// }
