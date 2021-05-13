package com.example.demo.model.domain;

public enum Permission
{
    USERS_READ("users:read"),
    USERS_WRITE("users:write");

    private final String permission;

    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission(){
        return permission;
    }
}
