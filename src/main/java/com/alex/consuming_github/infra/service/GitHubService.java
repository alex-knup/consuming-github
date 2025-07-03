package com.alex.consuming_github.infra.service;

import com.alex.consuming_github.domain.dto.UserListDTO;
import com.alex.consuming_github.infra.client.GitHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubService {

    @Autowired
    private GitHubClient client;

}
