<%-- 
    Document   : index
    Created on : Jan 12, 2021, 5:47:03 PM
    Author     : AnhDT
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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Product detail</title>

        <style>
            a:hover {
                color: red !important;
            }

            body {
                font-family: Arial;
                margin: 0;
            }

            * {
                box-sizing: border-box;
            }

            img {
                vertical-align: middle;
            }

            /* Position the image container (needed to position the left and right arrows) */
            .container-img {
                position: relative;
            }

            /* Hide the images by default */
            .mySlides {
                display: none;
            }

            /* Add a pointer when hovering over the thumbnail images */
            .cursor {
                cursor: pointer;
            }

            /* Next & previous buttons */
            .prev,
            .next {
                cursor: pointer;
                position: absolute;
                top: 40%;
                width: auto;
                padding: 16px;
                margin-top: -50px;
                color: #ccc;
                font-weight: bold;
                font-size: 30px;
                border-radius: 8px;
                user-select: none;
                -webkit-user-select: none;
                text-decoration: none;
            }

            /* Position the "next button" to the right */
            .next {
                right: 0;
                border-radius: 8px;
            }

            /* On hover, add a black background color with a little bit see-through */
            .prev:hover,
            .next:hover {
                background-color: rgba(0, 0, 0, 0.2);
            }
            /* Number text (1/3 etc) */
            .numbertext {
                color: #000;
                font-size: 16px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }

            /* Six columns side by side */
            .column {
                float: left;
                width: 16.66%;
            }

            /* Add a transparency effect for thumnbail images */
            .demo {
                opacity: 0.6;
            }

            .active,
            .demo:hover {
                opacity: 1;
            }
        </style>
    </head>
    <body>
        <%@ include file="component/navbar.jsp" %>

        <!--        <div class="container mt-5">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="container-img">
                                <div class="mySlides">
                                    <div class="numbertext">1 / ${requestScope.lsImage.size() + 1}</div> 
                                    <img src="assets/images/products/${product.imgName}" style="width:100%">
                                </div>
        <c:forEach items="${requestScope.lsImage}" var="image" varStatus="status">
            <div class="mySlides">
                <div class="numbertext">${status.count + 1} / ${requestScope.lsImage.size() + 1}</div>
                <img src="assets/images/products/${image.imageName}" style="width:100%">
            </div>
        </c:forEach>

        <a class="prev" onclick="plusSlides(-1)">❮</a>
        <a class="next" onclick="plusSlides(1)">❯</a>

        <div class="row">
            <div class="column">
                    <img class="demo cursor" src="assets/images/products/${product.imgName}" style="width:100%" onclick="currentSlide(1)">
                </div>
        <c:forEach items="${requestScope.lsImage}" var="image" varStatus="status">
            <div class="column">
                <img class="demo cursor" src="assets/images/products/${image.imageName}" style="width:100%" onclick="currentSlide(${status.count + 1})">
            </div>
        </c:forEach>
    </div>
</div>
</div>
<div class="col-md-1"></div>
<div class="col-md-5">
<h1 class="mt-5">${requestScope.product.name}</h1>
<h3>${requestScope.product.price}</h3>
<p>Số lượng: ${requestScope.product.quantity}</p>

<a href="" class="btn btn-danger mb-5">Thêm vào giỏ hàng</a>
<p>${requestScope.product.description}</p>
</div>
</div>
</div>

Option 1: Bootstrap Bundle with Popper 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
showSlides(slideIndex += n);
}

function currentSlide(n) {
showSlides(slideIndex = n);
}

function showSlides(n) {
var i;
var slides = document.getElementsByClassName("mySlides");
var dots = document.getElementsByClassName("demo");
if (n > slides.length) {
slideIndex = 1;
}
if (n < 1) {
slideIndex = slides.length;
}
for (i = 0; i < slides.length; i++) {
slides[i].style.display = "none";
}
for (i = 0; i < dots.length; i++) {
dots[i].className = dots[i].className.replace(" active", "");
}
slides[slideIndex - 1].style.display = "block";
dots[slideIndex - 1].className += " active";
}
</script>-->
        <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="assets/image/${oneProduct.imageURL}" height="450px"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${oneProduct.pname}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency">US $</span><span class="num">${oneProduct.price}</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>
                                                    ${oneProduct.description}

                                                </p></dd>
                                        </dl>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <dt>Quantity: </dt>
                                                    <dd>
                                                        <select class="form-control form-control-sm" style="width:70px;">
                                                            <option> 1 </option>
                                                            <option> 2 </option>
                                                            <option> 3 </option>
                                                        </select>
                                                    </dd>
                                                </dl>  <!-- item-property .// -->
                                            </div> <!-- col.// -->

                                        </div> <!-- row.// -->
                                        <hr>
                                        <a href="#" class="btn btn-lg btn-primary text-uppercase"> Buy now </a>
                                        <a href="#" class="btn btn-lg btn-outline-primary text-uppercase"> <i class="fas fa-shopping-cart"></i> Add to cart </a>
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->


                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
