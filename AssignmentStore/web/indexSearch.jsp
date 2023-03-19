<%-- 
    Document   : indexSearch
    Created on : Mar 15, 2021, 10:36:21 AM
    Author     : Marshallein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
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
    </style>
</head>
<body>
    <%@ include file="component/navbar.jsp" %>
    <h5 class="display-4" style="padding: 2rem 6rem;">Search result for ${searchtxt} found : ${listP.size()}</h5>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-2">
                <h5 class="mt-2">Size Gunpla and tools</h5>
                <c:forEach items="${listC}" var="cate">
                    <a class="mt-3" href="loadbycate?cid=${cate.cateID}&type=1">${cate.cateName}</a>
                </c:forEach>

                <!-- <h5 class="mt-5">Tools</h5>
                <c:forEach begin="1" end="6" var="category">
                    <a class="mt-3" href="#?id=#&type=2">test name</a>
                </c:forEach> -->
            </div>
            <div class="col-md-10">
                <div class="row">
                    <c:if test="${listP.size() == 0}">
                        <h3>
                            Product cant find pls wait for the Shop owner to update!
                            <img src="assets/image/404.png" alt="" style="background-color: white" style="margin-right: 10px"/>

                        </h3>
                    </c:if>
                    <c:forEach items="${listP}" var="product">
<!--                        <h3>${catebyid.cateDescription}</h3>-->
                        <div class="col-md-3 mt-4">

                            <div class="card">
                                <img src="assets/image/${product.imageURL}" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">
                                        <a href="#" style="text-decoration: none; color: #000; font-size: 18px;">
                                            ${product.pname}
                                        </a>
                                    </h5>
                                    <h5>${product.price}.00 $</h5>
                                    <a href="cart?id=${product.id}" class="btn btn-primary mt-2">Add to cart</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <%@ include file="component/footer.jsp" %>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
