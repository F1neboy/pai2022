package pl.edu.pbs.carrent.controller.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.carrent.controller.UserController;
import pl.edu.pbs.carrent.dto.UserUpdateDTO;
import pl.edu.pbs.carrent.model.User;
import pl.edu.pbs.carrent.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserControllerImpl implements UserController {

    private UserService userService;

    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.of(userService.getUserById(id));
    }

    @Override
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        return ResponseEntity.of(userService.updateUser(id, user));
    }
}
