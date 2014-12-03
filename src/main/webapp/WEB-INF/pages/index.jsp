<%--
  Created by IntelliJ IDEA.
  User: Artyom
  Date: 10.11.2014
  Time: 7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>ЯМА - Интернет магазин техники</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="res/stylesheet.css">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="res/prefixfree.min.js"></script>

    <script src="<c:url value="/res/events.js" />"></script>

    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700&amp;subset=latin,cyrillic-ext"
          rel="stylesheet" type="text/css">
</head>

<body>

<div class="container" style="position: relative;">
    <div class="ericpol-cart close">
        <table class="table table-striped table-hover">

        </table>
        <input class="in-bucket" style="width:100%; margin:0px;" type="button" value="Оплатить"/>
    </div>
</div>

<div class="navbar navbar-default navbar-static-top navbar-inverse ericpol-header">
    <div class="container">
        <div class="navbar-header">
            <a type="button" class="navbar-toggle ericpol-header-menu-button" data-toggle="collapse"
               data-target=".navbar-collapse"><img src="<c:url value="/res/menu-button-icon.gif" />" alt=""></a>
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          <span class="navbar-brand">
            <a href=""><img src="<c:url value="/res/logo.png" />" alt=""></a>
          </span>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="ericpol-header-active">
                    <a href="<c:url value="/" />">Главная</a>
                </li>
                <li>
                    <a href="<c:url value="/Catalog" />">Каталог</a>
                </li>
                <li>
                    <a href="#" name="cart">Корзина</a>
                </li>
            </ul>
        </div>
    </div>
</div>



<div class="hero-unit container ericpol-possib" align="center">

    <div class="col-md-3">
        <h2>Доставка</h2>
        <p class="small">Доставка за сутки по Бресту и Беларуси</p>
    </div>
    <div class="col-md-3">
        <h2>Оплата</h2>
        <p class="small">0% платежи от регионов, работает с юр. лицами</p>
    </div>
    <div class="col-md-3">
        <h2>Гарантия</h2>
        <p class="small">1 год на всю технику</p>
    </div>
    <div class="col-md-3">
        <h2>Сервис</h2>
        <p class="small">Сервис/Моддинг/Трейдин</p>
    </div>

</div>

<form class="ericpol-search container"  method="get" action="<c:url value="/Search"/>">
    <div>
        <input type="text" class="" placeholder="Поиск товара"><input type="submit" value="Поиск"/>
    </div>
</form>

<div id="carousel-example-generic" class="carousel slide container" data-interval="6000" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <div class="carousel-inner">

        <div class="item active" style="background-image: url(res/apple-imac-brend-stol.jpg);">
            <!--<img src="res/apple-imac-brend-stol.jpg">-->
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item" style="background-image: url(res/sony-vaio-xperia.jpg);">
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item" style="background-image: url(res/sony-vaio-noutbuk.jpg);">
            <div class="carousel-caption">
            </div>
        </div>

    </div>

    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div>


<div class="container ericpol-fast-search">
    <h3>Поиск по бренду</h3>

    <div class="hero-unit">
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li role="presentation"><a href="<c:url value="/Catalog?Brand=Apple" />">Apple</a></li>
                <li role="presentation"><a href="<c:url value="/Catalog?Brand=Acer" />">Acer</a></li>
                <li role="presentation"><a href="">Asus</a></li>
                <li role="presentation"><a href="">Toshiba</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li><a href="">Sony</a></li>
                <li><a href="">Samsung</a></li>
                <li><a href="">Simiens</a></li>
                <li><a href="">Lenovo</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li><a href="">MSI</a></li>
                <li><a href="">LG</a></li>
                <li><a href="">HP</a></li>
                <li><a href="">Fujitsu</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li><a href="">Dell</a></li>
                <li><a href="">Gigabyte</a></li>
                <li><a href="">Packard Bell</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container ericpol-fast-search">
    <h3>Поиск по типу продуцкии</h3>

    <div class="hero-unit">
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li role="presentation"><a href="">Мыши</a></li>
                <li role="presentation"><a href="">Клавиатуры</a></li>
                <li role="presentation"><a href="">Мониторы</a></li>
                <li role="presentation"><a href="">Принтеры</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li role="presentation"><a href="">MP3-плеееры</a></li>
                <li role="presentation"><a href="">Наушники</a></li>
                <li role="presentation"><a href="">Музыкальные центры</a></li>
                <li role="presentation"><a href="">Колонки</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li role="presentation"><a href="">Чехлы</a></li>
                <li role="presentation"><a href="">Мобильные телефоны</a></li>
                <li role="presentation"><a href="">Кабели</a></li>
                <li role="presentation"><a href="">Гарнитуры</a></li>
            </ul>
        </div>
        <div class="col-md-3 nav">
            <ul class="list-unstyled">
                <li role="presentation"><a href="">Компьютеры</a></li>
                <li role="presentation"><a href="<c:url value="/Catalog?Type=Laptops" />">Ноутбуки</a></li>
                <li role="presentation"><a href="">Моноблоки</a></li>
                <li role="presentation"><a href="">Сумки</a></li>
            </ul>
        </div>
    </div>
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
        <img src="<c:url value="/res/logo-footer.png" />" alt="">
        <br>Designed by
        <br>
        <a href="https://github.com/ArtyomShaitor/OnlineShopEricpol/"><img src="<c:url value="/res/github-icon.png" />" alt="">Ericpol Probationers</a>
    </div>
</div>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script>
    $(".navbar-brand a").click(function(){
        return false;
    })


</script>
</body>

</html>