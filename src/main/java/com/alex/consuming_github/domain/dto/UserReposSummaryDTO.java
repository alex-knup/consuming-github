package com.alex.consuming_github.domain.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "login",
        "total_repositories",
        "repositories"
})
public class UserReposSummaryDTO {

    private String login;
    @JsonProperty("total_repositories")
    private int totalRepositories;
    private List<UserRepositoriesDTO> repositories;

    public UserReposSummaryDTO(String login, List<UserRepositoriesDTO> repositories) {
        this.login = login;
        this.totalRepositories = repositories.size();
        this.repositories = repositories;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotalRepositories() {
        return totalRepositories;
    }

    public void setTotalRepositories(int totalRepositories) {
        this.totalRepositories = totalRepositories;
    }

    public List<UserRepositoriesDTO> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<UserRepositoriesDTO> repositories) {
        this.repositories = repositories;
    }
}
