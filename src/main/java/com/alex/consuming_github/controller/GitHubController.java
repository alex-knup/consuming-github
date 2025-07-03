package com.alex.consuming_github.controller;
import com.alex.consuming_github.domain.dto.UsersListDTO;
import com.alex.consuming_github.infra.service.GitHubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/github/api/v1")
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
}
