package org.example.onlinestoreservice.logic.impl;

import org.example.onlinestoreservice.Controller.JspPageName;
import org.example.onlinestoreservice.logic.CommandException;
import org.example.onlinestoreservice.logic.ICommand;

import javax.servlet.http.HttpServletRequest;

public class AdminLoggingCommand implements ICommand {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return JspPageName.ERROR_PAGE;
    }
}
