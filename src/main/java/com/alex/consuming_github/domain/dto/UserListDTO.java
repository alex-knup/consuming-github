package com.alex.consuming_github.domain.dto;

import java.util.List;

public class UserListDTO {

    private List<UserDTO> users;
    private String next;

    public UserListDTO() {
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
