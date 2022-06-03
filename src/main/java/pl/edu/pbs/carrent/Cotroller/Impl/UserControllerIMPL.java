package pl.edu.pbs.carrent.Cotroller.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pbs.carrent.Cotroller.UserController;
import pl.edu.pbs.carrent.DTO.UserUpdateDTO;
import pl.edu.pbs.carrent.Model.Users;
import pl.edu.pbs.carrent.Service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class UserControllerIMPL implements UserController {

    private UserService userService;

    @Override
    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.of(userService.getUserById(id));
    }

    @Override
    @PatchMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO user) {
        return ResponseEntity.of(userService.updateUser(id, user));
    }
}
