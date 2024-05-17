<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>


<main>
    <section class="py-5 text-center container">
        <h1>Destination</h1>
    </section>




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
                                       <h2 class="card-title">  </h2>
                                       <p class="card-text mb-1"><strong>Country: </strong>   </p>
                                       <p class="card-text mb-1"><strong>City: </strong>  </p>
                                       <p class="card-text mb-1"><strong>Description: </strong>   </p>
                                        <div>
                                            <button type="button" class="btn btn-dark">
                                                <i class="bi bi-plus-lg">Añadir</i>
                                            </button>
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


