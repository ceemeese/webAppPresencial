<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<script type="text/javascript">
    $(document).ready(function() {
        $("form").on("submit", function(event) {
            event.preventDefault();
            var formValue = $(this).serialize();
            $.post("edit-client", formValue, function(data) {
                $("#result").html(data);
            });
        });
    });
</script>



<main>
    <section class="py-5 text-center container">
            <h1>Register new client</h1>
    </section>

    <section class="container">
        <form class="" action="" method="post" content="text/html" enctype="multipart/form-data" >
            <div class="row">
                <div class="form-group col-md-4">
                    <label class="form-label" for="nif">NIF</label>
                    <input type="text" name="nif" class="form-control" id="nif" placeholder="NIF">
                </div>
                <div class="form-group col-md-4">
                    <label class="form-label" for="name">Name</label>
                    <input type="text" name="name" class="form-control" id="name" placeholder="Name">
                </div>
                <div class="form-group col-md-4">
                    <label class="form-label" for="surname">Surname</label>
                    <input type="text" name="surname" class="form-control" id="surname" placeholder="Surname">
                </div>
            </div>

            <div class="row mt-1">
                <div class="form-group col-md-6">
                    <label class="form-label" for="email">Email</label>
                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" aria-describedby="emailHelp">
                </div>
                <div class="form-group col-md-6">
                    <label class="form-label" for="mobile">Mobile</label>
                    <input type="text" name="mobile" class="form-control" id="mobile" placeholder="Mobile">
                </div>
            </div>
            <div class="row mt-1">
                <div class="form-group col-md-6">
                    <label class="form-label" for="address">Address</label>
                    <input type="text" name="address" class="form-control" id="address" placeholder="Address">
                </div>
                <div class="form-group col-md-6">
                    <label class="form-label" for="country">Country</label>
                    <input type="text" name="country" class="form-control" id="country" placeholder="Country">
                </div>
            </div>
            <button type="submit" class="btn btn-success mt-3">Submit</button>
            <input type="hidden" name="id" value="">
        </form>
        <br/>
        <div id="result"></div>
    </section>
</main>


<%@include file="includes/footer.jsp"%>


