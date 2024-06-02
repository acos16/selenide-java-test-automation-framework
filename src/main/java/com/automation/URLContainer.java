package com.automation;

import java.util.List;
import java.util.Map;

public class URLContainer {
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
