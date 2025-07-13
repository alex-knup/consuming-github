package com.alex.consuming_github.infra.service;
import com.alex.consuming_github.domain.dto.*;
import com.alex.consuming_github.infra.client.PublicApiGitHubClient;
import com.alex.consuming_github.infra.util.Utils;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsumingGitHubService {

    private final PublicApiGitHubClient client;

    public ConsumingGitHubService(PublicApiGitHubClient client) {
        this.client = client;
    }

    public UsersListDTO getUsers(int since) {
        List<UserDTO> listOfUsers = client.getUsers(since);
        UsersListDTO usersListDto = new UsersListDTO();
        usersListDto.setUsers(listOfUsers);
        if (!listOfUsers.isEmpty()) {
            Long lastId = listOfUsers.getLast().getId();
            String url = Utils.getBaseUrl() + "/github/api/v1/users?since=" + lastId;
            usersListDto.setNext(url);
        }
        return usersListDto;
    }

    public UserDetailsDTO getUserDetails(String username) {
        return client.getUserDetails(username);
    }

    public UserRepositorySummaryDTO getUsersRespositories(String username) {
        List<UserRepositoriesDTO> userRepositoriesDTOS = client.getUsersRepos(username);
        return new UserRepositorySummaryDTO(username, userRepositoriesDTOS);
    }
}
