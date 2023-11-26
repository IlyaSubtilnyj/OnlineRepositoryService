package org.example.onlinestoreservice.logic;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
    public String execute(HttpServletRequest request) throws CommandException;
}