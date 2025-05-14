package com.sportli.backend.service;

import java.util.Objects;
import com.sportli.backend.repository.UserRepository;
import com.sportli.backend.model.User;
import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createOrUpdateUser(User user) {

        if (user.getId() != null && userRepository.existsById(user.getId())) {

            User existingUser = userRepository.findById(user.getId()).get();

            // Using helper method to only change fields that are updated
            updateUserFieldsIfChanged(existingUser, user);

            return userRepository.save(existingUser);
        } else {
            return userRepository.save(user);
        }
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

    }

    // If a users fields are changed then we update that field
    private void updateUserFieldsIfChanged(User existingUser, User inputUser) {

        // Object is used here to safely compare two values and handle null properly
        if (inputUser.getEmail() != null && !Objects.equals(existingUser.getEmail(), inputUser.getEmail())) {
            existingUser.setEmail(inputUser.getEmail());
        }

        if (inputUser.getName() != null && !Objects.equals(existingUser.getName(), inputUser.getName())) {
            existingUser.setName(inputUser.getName());
        }

        if (inputUser.getSports() != null && !Objects.equals(existingUser.getSports(), inputUser.getSports())) {
            existingUser.setSports(inputUser.getSports());
        }

        if (inputUser.getSkillLevel() != null
                && !Objects.equals(existingUser.getSkillLevel(), inputUser.getSkillLevel())) {
            existingUser.setSkillLevel(inputUser.getSkillLevel());
        }

        if (inputUser.getAvailability() != null
                && !Objects.equals(existingUser.getAvailability(), inputUser.getAvailability())) {
            existingUser.setAvailability(inputUser.getAvailability());
        }

        if (inputUser.getBio() != null && !Objects.equals(existingUser.getBio(), inputUser.getBio())) {
            existingUser.setBio(inputUser.getBio());
        }

    }

}
