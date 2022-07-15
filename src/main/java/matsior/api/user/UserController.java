package matsior.api.user;

import lombok.RequiredArgsConstructor;
import matsior.api.user.dto.UserFullResponse;
import matsior.api.user.dto.UserSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {

    private final UserService userService;

    @GetMapping
    List<UserFullResponse> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    ResponseEntity<UserFullResponse> findUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<UserFullResponse> saveUser(@RequestBody UserSaveRequest userSaveRequest) {
        UserFullResponse savedUser = userService.saveUser(userSaveRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id())
                .toUri();
        return ResponseEntity.created(uri).body(savedUser);
    }
}
