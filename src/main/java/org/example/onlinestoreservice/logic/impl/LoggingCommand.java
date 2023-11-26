package org.example.onlinestoreservice.logic.impl;

import org.example.onlinestoreservice.Controller.JspPageName;
import org.example.onlinestoreservice.Role;
import org.example.onlinestoreservice.beans.User;
import org.example.onlinestoreservice.logic.CommandException;
import org.example.onlinestoreservice.logic.ICommand;

import javax.servlet.http.HttpServletRequest;

public class LoggingCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = null;
        User user_from_database = new User();
        user_from_database.setName("Ilya");
        user_from_database.setSignIn(true);
        request.getSession().setAttribute("user_entity_from_database", user_from_database);
        request.getSession().setAttribute("user", user_from_database);
        request.setAttribute("userRole", Role.CLIENT);
        page = JspPageName.USER_PAGE;
        return page;
    }
}
