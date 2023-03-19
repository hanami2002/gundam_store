<%-- 
    Document   : navbar
    Created on : Jan 14, 2021, 9:02:06 PM
    Author     : AnhDT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <img src="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" alt=" "height="50" width="50" style="background-color: white" style="margin-right: 10px"/>
        <a class="navbar-brand" href="home">Zxangunpla's Shop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="home">Home</a>
                </li>
                <c:if test="${sessionScope.account == null}">
                    <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Login</a>
                    </li>
                </c:if>


                <c:if test="${sessionScope.account != null}">
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                    <c:if test="${sessionScope.account.isSell == 1 || sessionScope.account.isAdmin == 1}" >
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Managerment
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:if test="${sessionScope.account.isAdmin == 1}">
                                    <li><a class="dropdown-item" href="accmanage">Account Manager</a></li>   
                                    </c:if>
                                    <c:if test="${sessionScope.account.isSell == 1}">
                                    <li><a class="dropdown-item" href="manage">Manage Product</a></li>
                                    <li><a class="dropdown-item" href="ordlist">Order</a></li>
                                    </c:if>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="register.jsp">Register</a></li>
                            </ul>
                        </li>

                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link" href="#">Hello ${sessionScope.account.username}</a>
                    </li>
                </c:if>

                <li class="nav-item" <c:if test="${sessionScope.account.isSell == 1 || sessionScope.account.isAdmin == 1}"> hidden </c:if> >
                    <a class="nav-link" href="cart.jsp">Cart<span class="badge rounded-pill bg-danger">${sessionScope.totalProducts}</span></a>
                </li>

            </ul>
            <form class="d-flex" action="search" method="post">
                <input class="form-control me-2" type="text" placeholder="Search" aria-label="Search" name="input-text">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
