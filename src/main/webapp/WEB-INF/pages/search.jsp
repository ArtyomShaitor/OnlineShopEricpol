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
    <title>ЯМА - Каталог</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/res/stylesheet.css"/>">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/res/prefixfree.min.js"/>"></script>

    <script src="<c:url value="/res/events.js" />"></script>

    <link href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700&amp;subset=latin,cyrillic-ext"
          rel="stylesheet" type="text/css">
</head>
<body>

<div class="navbar navbar-default navbar-static-top navbar-inverse ericpol-header">
    <div class="container">
        <div class="navbar-header">
            <a type="button" href="<c:url value="/"/>" class="navbar-toggle ericpol-header-menu-button" data-toggle="collapse"
               data-target=".navbar-collapse"><img src="<c:url value="/res/menu-button-icon.gif"/>" alt=""></a>
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          <span class="navbar-brand">
            <a href=""><img src="<c:url value="/res/logo.png"/>" alt=""></a>
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
                    <a href="#" name="cart">Корзина</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="container ericpol-catalog-container">
    <form class="ericpol-search container" method="get" action="<c:url value="/Search"/>">
        <div>
            <input type="text" class="" name="Query" placeholder="Поиск товара" value="${queryText}"><input type="submit" value="Поиск"/>
        </div>
    </form>


    <div class="col-md-12 right">
        <div class="block">
            <div class="search-result">
                Результаты поиска по запросу "${queryText}":
            </div>
        </div>
        <div class="block" style="margin-top: 15px !important;">
            <div class="items-view-list">
                <c:choose>
                    <c:when test="${itemListCount == 0}">
                        По вашему запросу ничего не найдено :(
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${itemList}" var="item">
                            <div class="item">
                                <img src="<c:url value="/res/catalog/${item.cover_url}"/>" alt=""/>
                                <div class="title">
                                        ${item.title}
                                    <div class="description">${item.description}</div>
                                    <span>Цена: ${item.price}$</span>
                                    <a href="<c:url value="/Catalog/Product/${item.id}"/>">Подробнее</a>
                                </div>
                            </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div align="center">
            <ul class="pagination">
                <li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
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
        <img src="<c:url value="/res/logo-footer.png"/>" alt="">
        <br>Designed by
        <br>
        <a href="https://github.com/ArtyomShaitor/OnlineShopEricpol/"><img src="<c:url value="/res/github-icon.png"/>" alt="">Ericpol Probationers</a>
    </div>
</div>
<script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function(){
        initScroll()
    });

    window.onscroll = function(){
        if( $(window).width() < 990 ) return false;
        initScroll();
    };

    initScroll = function (){
        if ( $(window).scrollTop() > 122 ) $(".left .block").addClass("sticky"); else $(".left .block").removeClass("sticky");
    };

</script>
</body>
</html>
