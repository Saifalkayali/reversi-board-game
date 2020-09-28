/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import model.Reversi;

/**
 * Web application lifecycle listener.
 *
 * @author saifalkayali
 */
public class SessionsListener implements HttpSessionListener {

    /**
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        final HttpSession session = se.getSession();
        session.setAttribute("game", new Reversi());
        session.getServletContext().log("New session started. Game added.");
        
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        
    }
}
