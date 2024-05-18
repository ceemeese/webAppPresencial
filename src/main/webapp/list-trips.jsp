<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.domain.Trip" %>
<%@ page import="java.util.List" %>
<%@ page import="com.svalero.webapppresencial.dao.TripDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>


<main>

  <section class="py-5 text-center container">

    <h1>Trips</h1>

     <table id="example" class="table table-striped table-hover" style="width:100%">
        <thead>
            <tr>
              <th>#</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>Client</th>
              <th>Type trip</th>
              <th></th>
            </tr>
        </thead>
        <tbody>
            <%
                Database.connect();
                List<Trip> trips = Database.jdbi.withExtension(TripDao.class, TripDao::getAllTrips);
                for (Trip trip : trips) {
            %>
            <tr>
              <td><%= trip.getIdTrip() %> </td>
              <td><%= trip.getStartDate() %>  </td>
              <td><%= trip.getEndDate() %></td>
              <td><%= trip.getIdUser().getName()%> <%= trip.getIdUser().getSurname()%></td>
              <td><%= trip.getIdType().getName() %></td>
              <td><a href="view-trip.jsp?idTrip=<%= trip.getIdTrip()%>" type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                <a href="" type="button" class="btn btn-sm btn-outline-secondary">Modify</a>
                <a href="remove-trip?idTrip=<%= trip.getIdTrip()%>" type="button" class="btn btn-sm btn-outline-danger">X</a>
              </td>
            </tr>
            <%
                }
            %>
          </tbody>
      </table>

      <a href="edit-trip.jsp" class="btn btn-success my-2">Add new trip</a>
  </section>


</main>

<%@include file="includes/footer.jsp"%>