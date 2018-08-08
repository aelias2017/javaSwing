/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.exception;

/**
 *
 * @author Alejandro Elias
 */
public class InvalidUserException extends Exception {

    /**
     * Creates a new instance of <code>InvalidCredentialsException</code>
     * without detail message.
     */
    public InvalidUserException() {
    }

    /**
     * Constructs an instance of <code>InvalidCredentialsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidUserException(String msg) {
        super(msg);
    }
}
