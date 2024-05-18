<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.domain.User" %>
<%@ page import="com.svalero.webapppresencial.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>


<main>
    <section class="py-5 text-center container">
        <h1>User</h1>
    </section>
    
    <%
        Integer idUser = Integer.parseInt(request.getParameter("idUser"));

        Database.connect();
        User user = Database.jdbi.withExtension(UserDao.class, dao-> dao.getUser(idUser));
    %>

    <div class="container">
        <div id="cardID" class="card" style="width: 20rem;">
            <h4 class="card-header text-center"> Personal information </h4>
            <div class="card-body">
                <h5 class="text-center"></h5>
                <p class="card-text"> <strong>NIF: </strong> <%= user.getNIF() %></p>
                <p class="card-text"> <strong>Name: </strong> <%= user.getName() %></p>
                <p class="card-text"> <strong>Surname: </strong> <%= user.getSurname() %></p>
                <p class="card-text"> <strong>Email: </strong> <%= user.getEmail() %></p>
                <p class="card-text"> <strong>Country: </strong> <%= user.getCountry() %></p>
                <p class="card-text"> <strong>Address: </strong> <%= user.getAddress() %></p>
                <p class="card-text"> <strong>Mobile: </strong> <%= user.getMobile() %></p>

                <a href="edit-client.jsp" class="btn btn-primary">Modify</a>
                <a href="" class="btn btn-danger">Delete</a>
            </div>
        </div>
    </div>

<%@include file="includes/footer.jsp"%>


