package com.alex.consuming_github.infra.client;
import com.alex.consuming_github.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient(name = "github", url = "https://api.github.com")
public interface GitHubClient {

    @GetMapping("/users")
    List<UserDTO> getUsers(@RequestParam("since") int since);
}
