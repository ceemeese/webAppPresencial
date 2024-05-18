package com.svalero.webapppresencial.servlet;

import com.svalero.webapppresencial.dao.Database;
import com.svalero.webapppresencial.dao.DestinationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/remove-destination")
public class removeDestination extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idDestination = Integer.parseInt(request.getParameter("idDestination"));

        try {
            Database.connect();
            int affectedRows = Database.jdbi.withExtension(DestinationDao.class,
                    dao -> dao.removeDestination(idDestination));

            response.sendRedirect("index.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
