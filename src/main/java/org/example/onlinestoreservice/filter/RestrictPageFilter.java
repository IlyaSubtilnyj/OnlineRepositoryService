package org.example.onlinestoreservice.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.example.onlinestoreservice.Controller.JspPageName;
import org.example.onlinestoreservice.Role;
import org.example.onlinestoreservice.beans.User;

import static org.example.onlinestoreservice.Controller.JspPageName.*;

public class RestrictPageFilter implements Filter {

    public static final int SESSION_LIFE_TIME_IN_SECONDS = 20;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        User auth = (User) req.getSession().getAttribute("user");
        String pageRequested = req.getServletPath();

        if (pageRequested.equals(CONTROLLER_PAGE)) {
            String command = req.getParameter("command");
            if (command != null && (command.equals("logging_command")||(command.equals("admin_logging_command")))) {
                req.setAttribute("pageRequested", pageRequested);
                req.getRequestDispatcher(CONTROLLER_PAGE).forward(req, res);
                return;
            }
        }

        if (isTryingToLog(pageRequested))
        {
            if (auth == null || !auth.isSignIn()) {
                req.setAttribute("pageRequested", pageRequested);
                req.getRequestDispatcher(CONTROLLER_PAGE).forward(req, res);
            } else {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().println("You have been stopped! You need to sign out to authorize again.");
            }
        } else
        {
            if (auth == null || !auth.isSignIn()) {
                String params = "?redirectTo=" + pageRequested;
                if (pageRequested.startsWith(ADMIN_PAGE))
                    res.sendRedirect(req.getContextPath() + ADMIN_PAGE + params);
                else res.sendRedirect(req.getContextPath() + LOGIN_PAGE + params);
            } else {
                if (/*user && */!req.getServletPath().startsWith(ADMIN_PAGE)) {
                    req.setAttribute("pageRequested", pageRequested);
                    req.getRequestDispatcher(CONTROLLER_PAGE).forward(req, res);
                } else {
                    res.sendError(403, "Access denied");
                }
            }
        }
    }

    boolean isTryingToLog(String page) {
        String clientLoginTemplate = "^/login/?$";
        String adminLoginTemplate = "^/admin/1btre34/?$";
        assert adminLoginTemplate.contains(ADMIN_PAGE);
        return page.matches(clientLoginTemplate) || page.matches(adminLoginTemplate);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
