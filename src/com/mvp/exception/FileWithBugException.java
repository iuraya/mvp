package com.mvp.exception;

/**
 * Class that indicate that a file contains a format error
 * It is thrown when the parsing process on a file cannot finish successfully
 */
public class FileWithBugException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileWithBugException (String message) {
        super(message);
    }
}