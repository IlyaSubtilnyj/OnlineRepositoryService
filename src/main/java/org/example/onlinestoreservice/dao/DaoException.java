package org.example.onlinestoreservice.dao;

import org.example.onlinestoreservice.exceptions.ProjectException;

public class DaoException extends ProjectException {
    private static final long serialVersionUID = 1L;
    public DaoException(String msg){
        super(msg);
    }
    public DaoException(String msg, Exception e){
        super(msg, e);
    }
}