package org.example.onlinestoreservice.Controller;

import org.example.onlinestoreservice.Role;
import org.example.onlinestoreservice.beans.User;
import org.example.onlinestoreservice.logic.CommandException;
import org.example.onlinestoreservice.logic.CommandHelper;
import org.example.onlinestoreservice.logic.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Ilya Gonzarevich i0treret@gmail.com
 * @version 1.0
 * @since 1.0
 */
public class Controller extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestParameterName.COMMAND_NAME);
        ICommand command = CommandHelper.getInstance().getCommand(commandName);
        String defaultRedirectPage = null;
        try {
            defaultRedirectPage = command.execute(req);
        } catch (CommandException e) {
            defaultRedirectPage = JspPageName.ERROR_PAGE;
        } catch (Exception e){
            defaultRedirectPage = JspPageName.ERROR_PAGE;
        }
        String requestedPage = req.getParameter("redirectTo");
        resp.sendRedirect(req.getContextPath() + (requestedPage == null ? defaultRedirectPage : requestedPage));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pageRequested = (String)req.getAttribute("pageRequested");
        //set attributes and another
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user_entity_from_database");
        Role userRole = (Role)session.getAttribute("userRole");
        req.getRequestDispatcher(pageRequested).forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
