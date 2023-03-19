<%-- 
    Document   : listorder
    Created on : Mar 30, 2021, 11:55:00 AM
    Author     : Marshallein
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Order</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />
    </head>
    <body>
        <h1>Order List</h1>
        <a href="admin" >back to Admin Page</a>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>ordID</th>
                    <th>Customer</th>
                    <th>Buyer ID</th>
                    <th>List Order</th>
                    <th>Total Price</th>
                    <th>Phone number</th>
                    <th>Date Created</th>
                    <th>Status</th>
                    <th>Note</th>
                    <th>Address</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listO}" var="o">
                <tr>
                    <td>${o.orderID}</td>
                    <td>${o.customer}</td>
                    <td>${o.accID}</td>
                    <td>${o.listOfOrder}</td>
                    <td>${o.totalMoney}</td>
                    <td>${o.phone}</td>
                    <td>${o.date}</td>
                    <td>${o.status}</td>
                    <td>${o.note}</td>
                    <td>${o.address}</td>
                    <td>
                        <a href="upstatus?uid=${o.orderID}" class="delete" onclick="return confirm('Done this order?');"><i class="material-icons" data-toggle="tooltip" title="done">done</i></a>
<!--                            <a href="update?uid=${o.orderID}"  class="edit"><i class="material-icons" data-toggle="tooltip" title="search">search</i></a>-->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
