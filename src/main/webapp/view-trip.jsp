<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.domain.Trip" %>
<%@ page import="com.svalero.webapppresencial.dao.TripDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>


<main>
    <section class="py-5 text-center container">
        <h1>Trip</h1>
    </section>

    <%
        Integer idTrip = Integer.parseInt(request.getParameter("idTrip"));

        Database.connect();
        Trip trip = Database.jdbi.withExtension(TripDao.class, dao-> dao.getTrip(idTrip));
    %>

    
    <div class="cream-bg">
        <div class="container">
            <div class="row g-5 justify-content-evenly">
                <div class="col lg-6">
                    <div class="card">
                        <div class="row g-0">
                            <div class="col-6 col-md-5">
                                <img class="card-img img-fluid rounded-start" src="trip-mediano.jpg" alt="trip">
                            </div>
                            <div class="col-6 col-md-7">
                                <div class="card-body d-flex flex-column">
                                   <div class="h-100">
                                       <h3 class="card-title"> <%= trip.getName() %> </h3>
                                       <h2 class="card-title"> <%= trip.getIdDestination().getCity() %> </h2>
                                       <p class="card-text mb-1"><strong>Start Date: </strong> <%= trip.getStartDate() %> </p>
                                       <p class="card-text mb-1"><strong>End Date: </strong> <%= trip.getEndDate() %>  </p>
                                       <p class="card-text mb-1"><strong>Name: </strong> <%= trip.getIdUser().getName() %> <%= trip.getIdUser().getSurname() %></p>
                                       <p class="card-text mb-1"><strong>Type: </strong> <%= trip.getIdType().getName() %> </p>
                                       <p class="card-text mb-1"><strong>Destination: </strong> <%= trip.getIdDestination().getCountry() %></p>
                                       <p class="card-text mb-1"><strong>Number travellers: </strong> <%= trip.getNumberTraveller() %> </p>
                                       <p class="card-text mb-1"><strong>Notes: </strong> <%= trip.getNotes() %> </p>
                                   </div>
                                    <div>
                                        <a href="remove-trip?idTrip=<%= trip.getIdTrip()%>" type="button" class="btn btn-sm btn-outline-danger">Delete</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<%@include file="includes/footer.jsp"%>


