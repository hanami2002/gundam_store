<%-- 
    Document   : cart
    Created on : Mar 2, 2021, 8:22:38 PM
    Author     : AnhDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Cart</title>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />

        <style>
            a {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>

        <c:choose>
            <c:when test="${sessionScope.listCart eq null}">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center mt-5">
                            <h4>No Product in here, Please add at least 1 Product to process to checkout </h4>
                            <a class="btn btn-info mt-3" href="home">Back to Home</a>
                        </div>                       
                    </div>                   
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 class="mt-5 mb-3">Cart</h3>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Image</th>
                                        <th>Item's Title</th>
                                        <th>Price</th>
                                        <th>Amount</th>
                                        <th>Total Money</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${sessionScope.listCart}" var="cart">
                                        <tr>
                                            <td>
                                                <img src="assets/image/${cart.imageURL}" width="60" />
                                            </td>
                                            <td>${cart.cname}</td>
                                            <td>${cart.price}</td>
                                            <td>
                                                <a class="me-3" href="updatecart?flag=1&id=${cart.id}" > - </a>
                                                ${cart.amount}
                                                <a class="ms-3" href="updatecart?flag=2&id=${cart.id}" > + </a>
                                            </td>
                                            <td>
                                                <fmt:formatNumber type="currency" currencySymbol="$" value="${cart.price * cart.amount}" />
                                            </td>
                                            <td>
                                                <a href="remove?id=${cart.id}">Delete</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <a class="btn btn-info" href="home">Continue to Purchase</a>
                        </div>
                        <div class="col-md-6 text-end">
                            <b class="me-4">
                                Total Money:
                                <fmt:formatNumber type="currency" currencySymbol="$" value="${sessionScope.totalMoney}" />
                            </b>

                            <a class="btn btn-danger me-2" href="removeallcart">Discard All</a>
                            <a class="btn btn-success" href="checkout.jsp" <c:if test="${sessionScope.account eq null}"> hidden </c:if> >Check Out</a>
                            <c:if test="${sessionScope.account eq null}"> <p>You must login to process to checkout</p></c:if>
                            </div>
                        </div>
                    </div>
            </c:otherwise>
        </c:choose>

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
