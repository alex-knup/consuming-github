package com.alex.consuming_github.domain.dto;

import java.util.List;

public class UsersListDTO {

    private List<UserDTO> users;
    private String next;

    public UsersListDTO() {
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
