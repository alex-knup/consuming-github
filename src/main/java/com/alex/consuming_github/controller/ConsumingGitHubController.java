package com.alex.consuming_github.controller;
import com.alex.consuming_github.domain.dto.*;
import com.alex.consuming_github.infra.service.ConsumingGitHubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/github/api/v2")
class ConsumingGitHubController {

    private final ConsumingGitHubService service;

    public ConsumingGitHubController(ConsumingGitHubService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<UsersListDTO> getUsers(@RequestParam(value = "since", defaultValue = "0") int since) {
        var usersListDto = service.getUsers(since);
        return ResponseEntity.ok(usersListDto);
    }

    @GetMapping("/users/{username}/details")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable String username) {
        var user = service.getUserDetails(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users/{username}/repositories")
    public ResponseEntity<UserRepositorySummaryDTO> getUserRepositories(@PathVariable String username) {
        return ResponseEntity.ok(service.getUsersRespositories(username));
    }
}
