<%@include file="includes/header.jsp"%>
<main>

    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Travel Manager</h1>
                <p class="lead text-body-secondary">An efficient travel manager can transform any business trip into an organized and stress-free experience.</p>
                <p>
                    <a href="" class="btn btn-success my-2">Add Destination</a>
                </p>
            </div>
        </div>
    </section>

    <section>

        <div class="album py-5 bg-body-tertiary">
            <div class="container">
                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">



                    <div class="col">
                        <div class="card shadow-sm">
                            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                                <title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/>
                                <text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text>
                            </svg>
                            <div class="card-body">
                                <p class="card-text"></p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                        <a href="view-destination.jsp" type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                                        <a href="" type="button" class="btn btn-sm btn-outline-secondary">Modify</a>
                                        <a href="" type="button" class="btn btn-sm btn-outline-danger">Delete</a>
                                    </div>
                                    <small class="text-body-secondary"> </small>
                                </div>
                            </div>
                        </div>
                    </div>





                </div>
            </div>
        </div>

    </section>



</main>

<%@include file="includes/footer.jsp"%>