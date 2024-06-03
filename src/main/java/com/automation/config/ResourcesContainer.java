package com.automation.config;

import com.automation.User;

import java.util.List;
import java.util.Map;

/**
 * ResourcesContainer contains the entities from the configuration file
 */
public class ResourcesContainer {
    private Map<String, String> urls;
    private List<User> users;

    public Map<String, String> getUrls() {
        return urls;
    }

    public void setUrls(Map<String, String> urls) {
        this.urls = urls;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
