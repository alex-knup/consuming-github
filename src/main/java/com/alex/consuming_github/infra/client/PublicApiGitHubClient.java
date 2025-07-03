package com.alex.consuming_github.infra.client;
import com.alex.consuming_github.domain.dto.UserDTO;
import com.alex.consuming_github.domain.dto.UserDetailsDTO;
import com.alex.consuming_github.domain.dto.UserRepositoriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "github", url = "https://api.github.com")
public interface PublicApiGitHubClient {

    @GetMapping("/users")
    List<UserDTO> getUsers(@RequestParam("since") int since);

    @GetMapping("/users/{username}")
    UserDetailsDTO getUserDetails(@PathVariable String username);

    @GetMapping("/users/{username}/repos")
    List<UserRepositoriesDTO> getUsersRepos(@PathVariable String username);
}
