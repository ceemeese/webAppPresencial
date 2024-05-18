package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.TripDao;
import com.svalero.webapppresencial.domain.Trip;
import com.svalero.webapppresencial.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/edit-trip")
public class editTrip extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (hasValidationErrors(request, response))
                return;

            //REVISAR POR QUE GENERA UNO NUEVO SI EDITAMOS
            int id = 0;
            if (request.getParameter("id_trip") != null) {
                id = Integer.parseInt(request.getParameter("id_trip"));
            }

            String name = request.getParameter("name");
            String notes = request.getParameter("notes");
            //Date startDate = DateUtils.parse(request.getParameter("dateStart"));
            //Date endDate = DateUtils.parse(request.getParameter("dateEnd"));
            int idType = Integer.parseInt(request.getParameter("typeTrip"));
            int idUser = Integer.parseInt(request.getParameter("user"));
            int idDestination = Integer.parseInt(request.getParameter("destination"));
            Integer numberTraveller = Integer.parseInt(request.getParameter("numberTraveller"));

            Database.connect();

            if ( id == 0) {
                int affectedRows = Database.jdbi.withExtension(TripDao.class, dao -> dao.addTrip(name, notes, idType, idUser, idDestination, numberTraveller));
                Database.close();
                sendMessage("New trip added", response);
            } else {
                final int finalID = id;
                int affectedRows = Database.jdbi.withExtension(TripDao.class, dao -> dao.updateTrip(name, notes, idType, idUser, idDestination, numberTraveller, finalID));
                Database.close();
                sendMessage("Trip modified", response);
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

        if (request.getParameter("notes").isBlank()) {
            sendError("Input notes can't be empty", response);
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
