package com.automation.entity;

/**
 * User class contains the User entity attributes, e.g.: username, password. More attributes can be
 * added. In that case the configuration file i.e. config.json needs to be updated too.
 */
public class User {

  private String username;
  private String password;

  /**
   * Gets the username of the User.
   *
   * @return username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets the username of the User.
   *
   * @param username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets the password of the User.
   *
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets the password of the User.
   *
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }
}
