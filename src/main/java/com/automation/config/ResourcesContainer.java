package com.automation.config;

import com.automation.entity.User;
import java.util.List;
import java.util.Map;

/** ResourcesContainer contains the entities from the configuration file */
public class ResourcesContainer {
  private Map<String, String> urls;
  private List<User> users;
  private Map<String, String> pages;

  /**
   * Gets the map of environment URLs.
   *
   * @return a map where the key is the environment name (e.g.: dev, qa) and the value is the URL of
   *     the environment.
   */
  public Map<String, String> getUrls() {
    return urls;
  }

  /**
   * Sets the map of environment URLs.
   *
   * @param urls
   */
  public void setUrls(Map<String, String> urls) {
    this.urls = urls;
  }

  /**
   * Gets the list of Users.
   *
   * @return a list of User objects.
   */
  public List<User> getUsers() {
    return users;
  }

  /**
   * Sets the list of Users.
   *
   * @param users
   */
  public void setUsers(List<User> users) {
    this.users = users;
  }

  /**
   * Gets the map of page URLs.
   *
   * @return a map where the key is the page name and the value is the URL of the page
   */
  public Map<String, String> getPages() {
    return pages;
  }

  /**
   * Sets the map of the page URLs.
   *
   * @param pages
   */
  public void setPages(Map<String, String> pages) {
    this.pages = pages;
  }
}
