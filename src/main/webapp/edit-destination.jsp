

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {
        $("form").on("submit", function(event) {
            event.preventDefault();
            var formValue = $(this).serialize();
            $.post("edit-breed", formValue, function(data) {
                $("#result").html(data);
            });
        });
    });
</script>

<%

%>

<main>
    <section class="py-5 text-center container">
        <h1>Register destination</h1>
    </section>

    <section class="container">
        <form class="" action="" method="post" content="text/html" enctype="multipart/form-data" >
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="city" class="form-label">City</label>
                    <input type="text" name="city" class="form-control" id="city">
                </div>
                <div class="form-group col-md-6">
                    <label for="country" class="form-label">Country</label>
                    <input type="text" name="country" class="form-control" id="country">
                </div>
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


