<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.domain.Destination" %>
<%@ page import="com.svalero.webapppresencial.dao.DestinationDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>


<main>
    <section class="py-5 text-center container">
        <h1>Destination</h1>
    </section>

    <%
        Integer idDestination = Integer.parseInt(request.getParameter("idDestination"));

        Database.connect();
        Destination destination = Database.jdbi.withExtension(DestinationDao.class, dao-> dao.getDestination(idDestination));
    %>



    <div class="cream-bg">
        <div class="container">
            <div class="row g-5 justify-content-evenly">
                <div class="col lg-6">
                    <div class="card">
                        <div class="row g-0">
                            <div class="col-6 col-md-5">
                                <img class="card-img img-fluid rounded-start" src="trip-mediano.jpg" alt="">
                            </div>
                            <div class="col-6 col-md-7">
                                <div class="card-body d-flex flex-column">
                                   <div class="h-100">
                                       <h3 class="card-title">DESTINATION</h3>
                                       <h2 class="card-title"> <%= destination.getCountry() %> </h2>
                                       <p class="card-text mb-1"><strong>Country:<%= destination.getCountry() %> </strong>  </p>
                                       <p class="card-text mb-1"><strong>City: <%= destination.getCity() %> </strong> </p>
                                       <p class="card-text mb-1"><strong>Description: </strong> <%= destination.getDescription() %>  </p>
                                        <div>
                                            <button type="button" class="btn btn-danger">Delete</button>
                                            <a href="remove-destination?idDestination=<%= destination.getIdDestination()%>" type="button" class="btn btn-sm btn-outline-danger">Delete</a>
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


