package fr.bsnt.service;

import fr.bsnt.model.Users;
import fr.bsnt.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<Users> getAllUsers() {
            return userRepository.findAll();
        }
        public Users getUserById(Long id) {
            return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
        }
        public Users createUser(Users users) {
            return userRepository.save(users);
        }
        public Users updateUser(Long id, Users users) {
            Users existingUsers = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
            existingUsers.setFirst_name(users.getFirst_name());
            existingUsers.setLast_name(users.getLast_name());
            existingUsers.setEmail(users.getEmail());
            existingUsers.setContact(users.getContact());
            return userRepository.save(existingUsers);
        }
        public void deleteUser(Long id) {
                userRepository.deleteById(id);
        }
}
