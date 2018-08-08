/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.getin.amazing.ws;

import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author aelias
 */
@ServerEndpoint("/endpoint")
public class WebSoket {

    @OnMessage
    public String onMessage(String message) {
        return null;
    }
    
}
