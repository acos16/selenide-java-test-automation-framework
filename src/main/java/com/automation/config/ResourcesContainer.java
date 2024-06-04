package com.automation.config;

import com.automation.entity.User;

import java.util.List;
import java.util.Map;

/**
 * ResourcesContainer contains the entities from the configuration file
 */
public class ResourcesContainer {
    private Map<String, String> urls;
    private List<User> users;
    private Map<String, String> pages;

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

    public Map<String, String> getPages() {
        return pages;
    }

    public void setPages(Map<String, String> pages) {
        this.pages = pages;
    }
}
