<%-- 
    Document   : admin.jsp
    Created on : Apr 2, 2021, 8:51:07 AM
    Author     : Marshallein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Zxangunpla</title>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />
        <style>
            a {
                display: block;
                text-decoration: none;
                color: #000;
                text-transform: uppercase;
                font-weight: 500;

            }
            a:hover {
                color: #89cff0 !important;

            }
            .row{
                border: ridge 1mm brown;
                padding-right: 3px;
            }
            .col-md-2 .mt-3:hover{
                border: solid 1px crimson;
                border-radius: 10px;
            }
            .jumbotron {
                padding: 2rem 1rem;
                margin-bottom: 2rem;
                background-color: #e9ecef;
                border-radius: .3rem;

            }
            h5{
                color: brown;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>
        
        <h1 style="text-align: center"> Currently Have ${listP.size()} Products available</h1>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3 class="mt-5 mb-3">All Product</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Products Name</th>
                                <th>Product Price</th>                                
                                <th>Description</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.listP}" var="list">
                                <tr>
                                    <td>
                                        <img src="assets/image/${list.imageURL}" width="60" />
                                    </td>
                                    <td>${list.pname}</td>
                                    <td>${list.price}</td>

                                    <td>
                                        ${list.description}
                                    </td>
                                    <td>
                                        <a href="update?uid=${list.id}" class="btn btn-primary mt-2">Edit Product</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
