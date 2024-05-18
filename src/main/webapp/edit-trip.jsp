<%@ page import="com.svalero.webapppresencial.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.svalero.webapppresencial.domain.Type" %>
<%@ page import="com.svalero.webapppresencial.domain.Destination" %>
<%@ page import="com.svalero.webapppresencial.domain.Trip" %>
<%@ page import="com.svalero.webapppresencial.dao.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {
        $("form").on("submit", function(event) {
            event.preventDefault();
            var formValue = $(this).serialize();
            $.post("edit-trip", formValue, function(data) {
                $("#result").html(data);
            });
        });
    });
</script>

<%
    int id;
    Trip trip = null;
    if (request.getParameter("id") == null) {
        id = 0;
    } else {
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        trip = Database.jdbi.withExtension(TripDao.class, dao-> dao.getTrip(id));
    }
%>



<main>
    <section class="py-5 text-center container">
        <h1>Register new trip</h1>
    </section>

    <section class="container">
        <form class="" action="" method="post" content="text/html" enctype="multipart/form-data" >
            <div class="row">
                <div class="form-group col-md-6">
                    <label class="form-label" for="name">Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="name">
                </div>
                <div class="form-group col-md-6" >
                    <label class="form-label" for="user">Client</label>
                    <select id="user" name="user" class="form-control">

                        <%
                            Database.connect();
                            List<User> users = Database.jdbi.withExtension(UserDao.class, UserDao::getAllUsers);
                            Database.close();
                            for (User user : users) {
                        %>
                        <option value="<%= user.getIdUser() %>"><%= user.getName() %> <%= user.getSurname() %></option>
                        <%
                            }
                        %>

                    </select>
                </div>
            </div>
            <div class="form-group mt-1">
                <label class="form-label" for="notes">Notes</label>
                <textarea class="form-control" name="notes" id="notes" rows="3"></textarea>
            </div>

            <div class="row mt-1">
                <div class="form-group col-md-6">
                    <label for="dateStart" class="form-label">Start Date</label>
                    <input type="date" name="dateStart" class="form-control" id="dateStart" placeholder="dd/mm/yyyy">
                </div>
                <div class="form-group col-md-6">
                    <label for="dateEnd" class="form-label">End Date</label>
                    <input type="date" name="dateEnd" class="form-control" id="dateEnd" placeholder="dd/mm/yyyy">
                </div>
            </div>

            <div class="row mt-1">
                <div class="form-group col-md-6">
                    <label class="form-label" for="typeTrip">Type Trip</label>
                    <select id="typeTrip" name="typeTrip" class="form-control">

                        <%
                            Database.connect();
                            List<Type> types = Database.jdbi.withExtension(TypeDao.class, TypeDao::getAllTypes);
                            Database.close();
                            for (Type type : types) {
                        %>
                        <option value="<%= type.getIdType() %>"><%= type.getName() %></option>
                        <%
                            }
                        %>

                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label class="form-label" for="destination">Destination</label>
                    <select id="destination" name="destination" class="form-control">

                        <%
                            Database.connect();
                            List<Destination> destinations = Database.jdbi.withExtension(DestinationDao.class, DestinationDao::getAllDestinations);
                            Database.close();
                            for (Destination destination : destinations) {
                        %>
                        <option value="<%= destination.getIdDestination() %>"><%= destination.getCountry() %></option>
                        <%
                            }
                        %>

                    </select>
                </div>
                <div class="form-group mt-1">
                    <label class="form-label" for="numberTraveller">Number of travellers</label>
                    <input type="text" name="numberTraveller" class="form-control" id="numberTraveller">
                </div>
            </div>


            <button type="submit" class="btn btn-success mt-3">Submit</button>
        </form>
        <br/>
        <div id="result"></div>
    </section>
</main>


<%@include file="includes/footer.jsp"%>


