package com.alex.consuming_github.controller;
import com.alex.consuming_github.domain.dto.*;
import com.alex.consuming_github.infra.service.GitHubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/github/api/v2")
class GitHubController {

    private final GitHubService service;

    public GitHubController(GitHubService service) {
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
    public ResponseEntity<UserReposSummaryDTO> getUserRepositories(@PathVariable String username) {
        return ResponseEntity.ok(service.getUsersRespos(username));
    }
}
