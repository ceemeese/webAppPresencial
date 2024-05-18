package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-user")
public class editUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (hasValidationErrors(request, response))
                return;

            //REVISAR POR QUE GENERA UNO NUEVO SI EDITAMOS
            int id = 0;
            if (request.getParameter("id_user") != null) {
                id = Integer.parseInt(request.getParameter("id_user"));
            }

            String NIF = request.getParameter("NIF");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            String mobile = request.getParameter("mobile");

            Database.connect();
            if ( id == 0) {
                int affectedRows = Database.jdbi.withExtension(UserDao.class, dao -> dao.addUser( NIF, name, surname, email, address, country, mobile));
                Database.close();
                sendMessage("New user added", response);
            } else {
                final int finalID = id;
                int affectedRows = Database.jdbi.withExtension(UserDao.class,
                        dao -> dao.updateUser( NIF, name, surname, email, address, country, mobile, finalID));
                Database.close();
                sendMessage("User modified", response);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            sendError("Se ha producido un error", response);
        } catch (SQLException e) {
            e.printStackTrace();
            sendError("Se ha producido un error durante la ejecución de la consulta", response);
        } catch (Exception e) {
            e.printStackTrace();
            sendError("Se ha producido una excepción", response);
        }
    }

    private boolean hasValidationErrors(HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean hasErrors = false;

        if (request.getParameter("NIF").isBlank()) {
            sendError("Input NIF can't be empty", response);
            hasErrors = true;
        }

        if (request.getParameter("mobile").isBlank()) {
            sendError("Input mobile can't be empty", response);
            hasErrors = true;
        }

        return hasErrors;
    }

    private void sendError(String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-danger' role='alert'>" + message + "</div>");
    }

    private void sendMessage(String message, HttpServletResponse response) throws IOException {
        response.getWriter().println("<div class='alert alert-success' role='alert'>" + message + "</div>");
    }

}
