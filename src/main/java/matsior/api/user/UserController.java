package matsior.api.user;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import matsior.api.user.dto.UserFullResponse;
import matsior.api.user.dto.UserSaveRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
class UserController {

    private final UserService userService;

    @Operation(summary = "Get list of all users")
    @GetMapping
    List<UserFullResponse> getUsers() {
        return userService.getUsers();
    }

    @Operation(summary = "Get single user by Id")
    @GetMapping("/{id}")
    ResponseEntity<UserFullResponse> findUserById(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Save new user")
    @PostMapping
    ResponseEntity<UserFullResponse> saveUser(@Valid @RequestBody UserSaveRequest userSaveRequest) {
        UserFullResponse savedUser = userService.saveUser(userSaveRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.id())
                .toUri();
        log.info("New user added: [id: {}, username: '{}']", savedUser.id(), savedUser.username());
        return ResponseEntity.created(uri).body(savedUser);
    }

    // FIXME 'created' field is null after replacing User
    @Operation(summary = "Replacing user by Id")
    @PutMapping("/{id}")
    ResponseEntity<?> replaceUser(@PathVariable Long id, @Valid @RequestBody UserSaveRequest userSaveRequest) {
        log.info("Replacing user with Id: {}", id);
        return userService.replaceUser(id, userSaveRequest)
                .map(user -> ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete user by Id")
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id) {
        userService.deleteUser(id);
        log.info("Deleted beer style with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
