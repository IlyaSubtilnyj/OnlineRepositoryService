package org.example.onlinestoreservice.logic.impl;

import org.example.onlinestoreservice.Controller.JspPageName;
import org.example.onlinestoreservice.logic.CommandException;
import org.example.onlinestoreservice.logic.ICommand;

import javax.servlet.http.HttpServletRequest;

public class NoSuchCommand implements ICommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = JspPageName.USER_PAGE;
        return page;
    }
}
