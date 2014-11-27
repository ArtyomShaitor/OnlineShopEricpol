<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 13.11.2014
  Time: 6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ЯМА - Каталог | ${item.title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="../../res/stylesheet.css">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="../../res/prefixfree.min.js"></script>

    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700&amp;subset=latin,cyrillic-ext"
          rel="stylesheet" type="text/css">
</head>
<body>
<div class="navbar navbar-default navbar-static-top navbar-inverse ericpol-header">
    <div class="container">
        <div class="navbar-header">
            <a type="button" href="<c:url value="/"/>" class="navbar-toggle ericpol-header-menu-button" data-toggle="collapse"
               data-target=".navbar-collapse"><img src="../../res/menu-button-icon.gif" alt=""></a>
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          <span class="navbar-brand">
            <a href=""><img src="../../res/logo.png" alt=""></a>
          </span>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/"/>">Главная</a>
                </li>
                <li class="ericpol-header-active">
                    <a href="<c:url value="/Catalog"/>">Каталог</a>
                </li>
                <li>
                    <a href="#">Корзина</a>
                </li>
            </ul>
        </div>
    </div>
</div>


<ol class="breadcrumb container">
    <li><a href="<c:url value="/Catalog"/>">Каталог</a></li>
    <li class="active"> ${item.title}</li>
</ol>

<div class="ericpol-item-catalog-container container">
    <div class="title">${item.title}</div>
    <img src="../../res/catalog/${item.cover_url}" alt=""/>
    <h3>Описание</h3>
    <div class="description">${item.description}</div>
    <h3>Цена</h3>
    <div class="price">${item.price}$</div>
</div>

<div class="container">
    <input class="in-bucket" type="button" value="В корзину"/>
</div>


<div class="container ericpol-footer">
    <div class="col-md-4" align="left">
        <div class="title">Контакты</div>
        <ul>
            <li>+375(25)123-45-67</li>
            <li>shop@jama.com</li>
            <li>ул. Держинского, д.52</li>
        </ul>
    </div>
    <div class="col-md-4" align="center">
        <div class="title">Тех. поддержка</div>
        <ul>
            <li>+375(162)98-76-54</li>
            <li>support@jama.com</li>
        </ul>
    </div>
    <div class="col-md-4" align="right">
        <img src="../../res/logo-footer.png" alt="">
        <br>Designed by
        <br>
        <a href="https://github.com/ArtyomShaitor/OnlineShopEricpol/"><img src="../../res/github-icon.png" alt="">Ericpol Probationers</a>
    </div>
</div>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>

