package com.scaler.stocktradingapp;

import com.scaler.stocktradingapp.model.User;
import com.scaler.stocktradingapp.repository.UserRepository;
import com.scaler.stocktradingapp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private final UserRepository userRepository = Mockito.mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void testCreateUser() {
        User user = new User();
        user.setName("John Doe");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);
        assertEquals("John Doe", createdUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> fetchedUser = userService.getUserById(1L);
        assertTrue(fetchedUser.isPresent());
        assertEquals("John Doe", fetchedUser.get().getName());
    }
}