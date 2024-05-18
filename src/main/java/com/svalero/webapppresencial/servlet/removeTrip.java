package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.TripDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/remove-trip")
public class removeTrip extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idTrip = Integer.parseInt(request.getParameter("idTrip"));

        try {
            Database.connect();
            int affectedRows = Database.jdbi.withExtension(TripDao.class,
                    dao -> dao.removeTrip(idTrip));

            response.sendRedirect("list-trips.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
