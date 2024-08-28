package com.automation.exceptions;

/** Custom exception class for the test automation framework. */
public class CustomException extends RuntimeException {

  private static final long serialVersionUID = 3890665606289142832L;

  /**
   * Constructor with a custom message.
   *
   * @param message
   */
  public CustomException(String message) {
    super(message);
  }

  /**
   * Constructor with a custom message and a cause
   *
   * @param message
   * @param cause
   */
  public CustomException(String message, Throwable cause) {
    super(message, cause);
  }
}
