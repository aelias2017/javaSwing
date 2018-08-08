/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matersys.escuelaapp.exeption;

/**
 *
 * @author eiste
 */
public class InvalidPermException extends Exception {

    /**
     * Creates a new instance of <code>InvalidPermException</code> without
     * detail message.
     */
    public InvalidPermException() {
    }

    /**
     * Constructs an instance of <code>InvalidPermException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidPermException(String msg) {
        super(msg);
    }
}
