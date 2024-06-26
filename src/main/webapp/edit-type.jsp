<%@ page import="com.svalero.webapppresencial.domain.Type" %>
<%@ page import="com.svalero.webapppresencial.dao.Database" %>
<%@ page import="com.svalero.webapppresencial.dao.TypeDao" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {
        $("form").on("submit", function(event) {
            event.preventDefault();
            var formValue = $(this).serialize();
            $.post("edit-type", formValue, function(data) {
                $("#result").html(data);
            });
        });
    });
</script>

<%
    int id;
    Type type = null;
    if (request.getParameter("id") == null) {
        id = 0;
    } else {
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        type = Database.jdbi.withExtension(TypeDao.class, dao-> dao.getType(id));
    }
%>

<main>
    <section class="py-5 text-center container">
        <h1>Register type of trip</h1>
    </section>

    <section class="container">
        <form class="" action="" method="post" content="text/html" enctype="multipart/form-data" >
            <div class="form-group">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" name="name" class="form-control" id="name">
            </div>
            <div class="form-group mt-1">
                <label class="form-label" for="description">Description</label>
                <textarea class="form-control" name="description" id="description" rows="3"></textarea>
            </div>

            <button type="submit" class="btn btn-success mt-3">Submit</button>
        </form>
        <br/>
        <div id="result"></div>
    </section>
</main>


<%@include file="includes/footer.jsp"%>


