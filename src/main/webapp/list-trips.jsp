<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<main>

  <section class="py-5 text-center container">

    <h1>Trips</h1>

     <table id="example" class="table table-striped table-hover" style="width:100%">
        <thead>
            <tr>
              <th>#</th>
              <th>Start Date</th>
              <th>End Date</th>
              <th>Client</th>
              <th>Type trip</th>
              <th></th>
            </tr>
        </thead>
        <tbody>
            <tr>
              <td> </td>
              <td> </td>
              <td> </td>
              <td> </td>
              <td> </td>
              <td><a href="view-trip.jsp" type="button" class="btn btn-sm btn-outline-secondary">Details</a>
                <a href="" type="button" class="btn btn-sm btn-outline-secondary">Modify</a>
                <a href="" type="button" class="btn btn-sm btn-outline-danger">X</a>
              </td>
            </tr>
          </tbody>
      </table>

      <a href="" class="btn btn-dark my-2">Add new trip</a>
  </section>


</main>

<%@include file="includes/footer.jsp"%>