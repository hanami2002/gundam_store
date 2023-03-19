<%-- 
    Document   : Detail
    Created on : Mar 9, 2021, 10:23:05 AM
    Author     : Marshallein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Detail</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/png" href="assets/resource/gundam_rx_78_2_by_vietanhussr_d4csudy-fullview.png" />
        <style>
            body {
                background-color: #000
            }

            .card {
                border: none
            }

            .product {
                background-color: #eee
            }

            .brand {
                font-size: 13px
            }

            .act-price {
                color: red;
                font-weight: 700
            }

            .dis-price {
                text-decoration: line-through
            }

            .about {
                font-size: 14px
            }

            .color {
                margin-bottom: 10px
            }

            label.radio {
                cursor: pointer
            }

            label.radio input {
                position: absolute;
                top: 0;
                left: 0;
                visibility: hidden;
                pointer-events: none
            }

            label.radio span {
                padding: 2px 9px;
                border: 2px solid #ff0000;
                display: inline-block;
                color: #ff0000;
                border-radius: 3px;
                text-transform: uppercase
            }

            label.radio input:checked+span {
                border-color: #ff0000;
                background-color: #ff0000;
                color: #fff
            }

            .btn-danger {
                background-color: #ff0000 !important;
                border-color: #ff0000 !important
            }

            .btn-danger:hover {
                background-color: #da0606 !important;
                border-color: #da0606 !important
            }

            .btn-danger:focus {
                box-shadow: none
            }

            .cart i {
                margin-right: 10px
            }


        </style>
        <script>
            function change_image(image) {

                var container = document.getElementById("main-image");

                container.src = image.src;
            }



            document.addEventListener("DOMContentLoaded", function (event) {







            });
        </script>
    </head>
    <body>
        <jsp:include page="component/navbar.jsp"></jsp:include>

            <div class="container mt-5 mb-5">
                <div class="row d-flex justify-content-center">
                    <div class="col-md-10">
                        <div class="card">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="images p-3">
                                        <div class="text-center p-4"> <img id="main-image" src="assets/image/${oneProduct.imageURL}" width="400" /> </div>
                                    <!--<div class="thumbnail text-center"> <img onclick="change_image(this)" src="https://i.imgur.com/Rx7uKd0.jpg" width="70"> <img onclick="change_image(this)" src="https://i.imgur.com/Dhebu4F.jpg" width="70"> </div>-->
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="product p-4">
                                    <div class="d-flex justify-content-between align-items-center">
                                        <div class="d-flex align-items-center"> <i class="fa fa-long-arrow-left"></i> 
                                            <!--                                                <span class="ml-1">Back</span> -->
                                        </div> 
                                        <i class="fa fa-shopping-cart text-muted">

                                        </i>
                                    </div>
                                    <div class="mt-4 mb-3"> 
                                        <!--
                                            <span class="text-uppercase text-muted brand">Orianz</span>-->
                                        <h5 class="text-uppercase">${oneProduct.pname}</h5>
                                        <div class="price d-flex flex-row align-items-center"> 
                                            <span class="act-price">${oneProduct.price}.0 $</span>
                                            <!--  
                                                <div class="ml-2"> <small class="dis-price">$59</small> 
                                                    <span>40% OFF</span> 
                                                </div>-->
                                        </div>
                                    </div>
                                    <p class="description">${oneProduct.description}</p>
                                    <form action="cart" method="get">
                                        <input name="id" value="${oneProduct.id}" hidden>
                                        <div class="cart mt-4 align-items-center"> <button class="btn btn-danger text-uppercase mr-2 px-4">Add to cart</button> <i class="fa fa-heart text-muted"></i> <i class="fa fa-share-alt text-muted"></i> </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="component/footer.jsp"></jsp:include>
    </body>
</html>
