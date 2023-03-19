<%-- 
    Document   : checkout
    Created on : Mar 9, 2021, 9:03:54 PM
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
        <title>Confirm Checkout</title>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h3 class="mt-5 mb-3">Cart Checkout</h3>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Item's Title</th>
                                <th>Price</th>
                                <th>Amount</th>
                                <th>Total Money</th>
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
                                        ${cart.amount}
                                    </td>
                                    <td>
                                        <fmt:formatNumber type="currency" currencySymbol="$" value="${cart.price * cart.amount}" />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-end">
                        <b>
                            Total Money
                            <fmt:formatNumber type="currency" currencySymbol="$" value="${sessionScope.totalMoney}" />
                        </b>
                    </div>
                    <div>
                        <a class="btn btn-danger w-100 mt-4 btn-lg" href="removeallcart" onclick="return confirm('Do you want to cancel the order?');">Cancel Order</a>
                    </div>
                </div>
                <div class="col-md-5 ps-5">
                    <h3 class="mt-5 mb-4">Information</h3>
                    <div>
                        <form action="ordercheckout" method="post">
                            <div class="mb-2">
                                <label for="name" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="name" name="name">
                            </div>
                            <div class="mb-2">
                                <label for="mobile" class="form-label">Phone Number</label>
                                <input type="text" class="form-control" id="mobile" name="mobile">
                            </div>
                            <div class="mb-2">
                                <label for="address" class="form-label">Address</label>
                                <textarea class="form-control" id="address" name="address" rows="2"></textarea>
                            </div>
                            <div class="mb-2">
                                <label for="note" class="form-label">Note</label>
                                <textarea class="form-control" id="note" name="note" rows="2"></textarea>
                            </div>
                            <button type="submit" class="btn btn-success w-100 mt-2 btn-lg">Submit Order</button>                                
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
