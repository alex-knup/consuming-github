package com.alex.consuming_github.controller;
import com.alex.consuming_github.domain.dto.UserDTO;
import com.alex.consuming_github.domain.dto.UserListDTO;
import com.alex.consuming_github.infra.client.GitHubClient;
import com.alex.consuming_github.infra.service.GitHubService;
import com.alex.consuming_github.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/github/api/v1")
class GitHubController {

    private final GitHubClient client;

    public GitHubController(GitHubClient client) {
        this.client = client;
    }

    @GetMapping("/users")
    public ResponseEntity<UserListDTO> getUsers(@RequestParam(value = "since", defaultValue = "0") int since) {
        List<UserDTO> listOfUsers = client.getUsers(since);
        UserListDTO usersListDto = new UserListDTO();
        usersListDto.setUsers(listOfUsers);
        if (!listOfUsers.isEmpty()) {
            Long lastId = listOfUsers.getLast().getId();
            String url = Utils.getBaseUrl() + "/github/api/v1/users?since=" + lastId;
            usersListDto.setNext(url);
        }
        return ResponseEntity.ok(usersListDto);
    }
}
