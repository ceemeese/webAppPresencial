package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.TypeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-type")
public class editType extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (hasValidationErrors(request, response))
                return;

            //REVISAR POR QUE GENERA UNO NUEVO SI EDITAMOS
            int id = 0;
            if (request.getParameter("id_type") != null) {
                id = Integer.parseInt(request.getParameter("id_type"));
            }

            String name = request.getParameter("name");
            String description = request.getParameter("description");

            Database.connect();
            if ( id == 0) {
                int affectedRows = Database.jdbi.withExtension(TypeDao.class, dao -> dao.addType(name, description));
                Database.close();
                sendMessage("New type added", response);
            } else {
                final int finalID = id;
                int affectedRows = Database.jdbi.withExtension(TypeDao.class,
                        dao -> dao.updateType(name, description, finalID));
                Database.close();
                sendMessage("Type modified", response);
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

        if (request.getParameter("name").isBlank()) {
            sendError("Input name can't be empty", response);
            hasErrors = true;
        }

        if (request.getParameter("description").isBlank()) {
            sendError("Input description can't be empty", response);
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
