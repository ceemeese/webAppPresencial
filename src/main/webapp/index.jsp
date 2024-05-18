<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.domain.Destination" %>
<%@ page import="java.util.List" %>
<%@ page import="com.svalero.webapppresencial.dao.DestinationDao" %>
<%@include file="includes/header.jsp"%>
<main>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Travel Manager</h1>
                <p class="lead text-body-secondary">An efficient travel manager can transform any business trip into an organized and stress-free experience.</p>
                <p>
                    <a href="edit-destination.jsp" class="btn btn-success my-2">Add Destination</a>
                </p>
            </div>
        </div>
    </section>

    <section>

        <div class="album py-5 bg-body-tertiary">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

                    <%
                        Database.connect();
                        List<Destination> destinations = Database.jdbi.withExtension(DestinationDao.class, DestinationDao::getAllDestinations);
                        for (Destination destination : destinations) {
                    %>

                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="avion.jpg" class="bd-placeholder-img card-img-top" width="100%" height="225" role="img" preserveAspectRatio="xMidYMid slice" focusable="false">
                                <title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/>
                            </img>
                            <div class="card-body">
                                <p class="card-text"><%= destination.getCountry() %> - <%= destination.getCity() %></p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="view-destination.jsp?idDestination=<%= destination.getIdDestination()%>" type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                                        <a href="edit-destination.jsp?idDestination=<%= destination.getIdDestination()%>" type="button" class="btn btn-sm btn-outline-secondary">Modify</a>
                                        <a href="remove-destination?idDestination=<%= destination.getIdDestination()%>" type="button" class="btn btn-sm btn-outline-danger">Delete</a>
                                    </div>
                                    <small class="text-body-secondary"> </small>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%
                        }
                    %>





                </div>
            </div>
        </div>

    </section>



</main>

<%@include file="includes/footer.jsp"%>