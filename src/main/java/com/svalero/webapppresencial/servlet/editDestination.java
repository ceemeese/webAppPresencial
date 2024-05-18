package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.DestinationDao;
import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.domain.Destination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-destination")
public class editDestination extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (hasValidationErrors(request, response))
                return;

            //REVISAR POR QUE GENERA UNO NUEVO SI EDITAMOS
            int id = 0;
            if (request.getParameter("id_destination") != null) {
                id = Integer.parseInt(request.getParameter("id_destination"));
            }

            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String description = request.getParameter("description");

            Database.connect();
            if ( id == 0) {
                int affectedRows = Database.jdbi.withExtension(DestinationDao.class, dao -> dao.addDestination(city, country, description));
                Database.close();
                sendMessage("New destination added", response);
            } else {
                final int finalID = id;
                int affectedRows = Database.jdbi.withExtension(DestinationDao.class,
                        dao -> dao.updateDestination(city, country, description, finalID));
                Database.close();
                sendMessage("Destination Modified", response);
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

        if (request.getParameter("city").isBlank()) {
            sendError("Input city can't be empty", response);
            hasErrors = true;
        }

        if (request.getParameter("country").isBlank()) {
            sendError("Input country can't be empty", response);
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
